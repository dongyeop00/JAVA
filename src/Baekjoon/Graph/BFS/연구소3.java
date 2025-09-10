package Baekjoon.Graph.BFS;

import java.util.*;
import java.io.*;

public class 연구소3 {
	
	static int N, M, shortTime;
	static List<Virus> list;
	static Virus[] virus;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int INF = 1_000_000_000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		list = new ArrayList<>(); // 몇개인지 모르는 바이러스를 저장할 공간
		shortTime = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) list.add(new Virus(i, j));
				
			}
		}
		
		// 바이러스 중 M개만큼 조합을 만들어야 하니 M개 만큼 선언
		virus = new Virus[M];
		
		// 조합 생성
		permutation(0, 0);
		System.out.println(shortTime == INF ? -1 : shortTime);
	}
	
	public static void permutation(int depth, int index) {
		if(depth == M) {
			shortTime = Math.min(shortTime, BFS(virus));
			return;
		}
		
		for(int i=index; i<list.size(); i++) {
			virus[depth] = list.get(i);
			permutation(depth+1, i+1);
		}
	}
	
	public static int BFS(Virus[] virus) {
		// BFS 준비
		Queue<Virus> queue = new LinkedList<>();
		int[][] time = new int[N][N];
		for(int i=0; i<N; i++) Arrays.fill(time[i], INF);
		
		// 조합 바이러스 활성화
		for(Virus v : virus) {
			queue.offer(new Virus(v.x, v.y, 0));
			time[v.x][v.y] = 0;
		}
		
		while(!queue.isEmpty()) {
			Virus current = queue.poll();
			
			if(time[current.x][current.y] < current.time) continue;
			
			for(int i=0; i<4; i++) {
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];
				int newTime = current.time + 1;
				
				if(newX < 0 || newY < 0 || newX >= N || newY >= N) continue;
				if(map[newX][newY] == 1) continue; // 벽은 통과 못함
				
				if(time[newX][newY] > newTime) {
					time[newX][newY] = newTime;
					queue.offer(new Virus(newX, newY, newTime));
				}
			}
		}
	
		int max = 0;
		boolean hasEmpty = false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) { // 길에서만 대해서 탐색한다.
					hasEmpty = true; // 이동할 수 있는 칸이 있다
					if(time[i][j] == INF) { // 근데 그 칸이 못가는 곳이면
						return INF; // INF를 반환
					}
					max = Math.max(max, time[i][j]);
				}
			}
		}
		return hasEmpty ? max : 0;
	}
	
	
	public static class Virus{
		int x;
		int y;
		int time;
		
		Virus(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		Virus(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
