package Baekjoon;

import java.util.*;
import java.io.*;

public class 뱀 {

	static int N, K;
	static boolean[][] apple;
	static boolean[][] snake;
	static int[] dx = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 보드 크기
		apple = new boolean[N+1][N+1];
		snake = new boolean[N+1][N+1];
		
		K = Integer.parseInt(br.readLine()); // 사과의 개수
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			apple[x][y] = true;
		}
		
		int L = Integer.parseInt(br.readLine()); // 방향 변환 회수 L
		Queue<Direction> dirQueue = new LinkedList<>();
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			dirQueue.offer(new Direction(time, dir));
		}
		
		System.out.println(simulation(dirQueue));
	}
	
	public static int simulation(Queue<Direction> dirQueue) {
		Deque<Snake> queue = new ArrayDeque<>();
		queue.offer(new Snake(1, 1));
		snake[1][1] = true;
		int dir = 0; // 처음 방향은 오른쪽
		int time = 0;
		
		while(true) {
			time++;
			
			// 1. 머리 이동 및 점유
			Snake head = queue.peekFirst();
			int newX = head.x + dx[dir];
			int newY = head.y + dy[dir];
			queue.addFirst(new Snake(newX, newY));
			snake[newX][newY] = true;
			
			// 2. 맵 범위 밖에 있거나, 자신의 몸과 부딪힌다면
			if(!isIn(newX, newY) || snake[newX][newY]) {
				return time;
			}
			
			// 3. 사과 처리
			if(apple[newX][newY]) { // 다음 위치에 사과가 있다면
				apple[newX][newY] = false; // 사과 먹음
			}else {
				Snake tail = queue.removeLast();
				snake[tail.x][tail.y] = false; //현재칸은 없애고
			}
			
			// 4. 방향 처리
			if(!dirQueue.isEmpty() &&  dirQueue.peek().time == time) {
				Direction current = dirQueue.poll();
				if(current.dir == 'D') {
					dir = (dir+1)%4; // 오른쪽으로 이동
				}else {
					dir = (dir+3)%4; // 왼쪽으로 이동
				}
			}
		}
	}
	
	public static boolean isIn(int x, int y) {
		return 1 <= x && 1 <= y && x <= N && y <= N;
	}

	public static class Snake{
		int x;
		int y;
		
		Snake(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static class Direction{
		int time;
		char dir;
		
		Direction(int time, char dir){
			this.time = time;
			this.dir = dir;
		}
	}

}
