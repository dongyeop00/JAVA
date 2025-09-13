package Baekjoon.모의SW역량테스트;

import java.util.*;
import java.io.*;

public class 점심식사시간 {

	static int N, minTime;
	static int[][] map;
	static List<Human> humanList;
	static List<Stair> stairList;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			minTime = Integer.MAX_VALUE;
			humanList = new ArrayList<>();
			stairList = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) humanList.add(new Human(i, j));
					else if(map[i][j] != 0) stairList.add(new Stair(i,j, map[i][j]));
				}
			}


			visited = new boolean[humanList.size()];
			subset(0, humanList.size());
			
			System.out.println("#" + testCase + " " + minTime);
		}
	}
	
	private static void subset(int depth, int stop) {
		if(depth == stop) {
			minTime = Math.min(minTime, simulation(visited));
			return;
		}
		
		visited[depth] = true;
		subset(depth+1, stop);
		
		visited[depth] = false;
		subset(depth+1, stop);
	}
	
	private static int simulation(boolean[] visited) {
		// 계단을 이용 하는 사람을 부분집합으로  true / false로 나눴음
		// 사람별 계단 입구까지 이동 시간을 계산한 뒤, 오름 차순으로 정렬
		List<Integer> stairArray1 = new ArrayList<>();
		List<Integer> stairArray2 = new ArrayList<>();
		
		Stair stair1 = stairList.get(0);
		Stair stair2 = stairList.get(1);
		
		for(int i=0; i<humanList.size(); i++) {
			if(visited[i]) {
				stairArray1.add(distance(stair1.x, stair1.y, humanList.get(i).x, humanList.get(i).y));
			}else {
				stairArray2.add(distance(stair2.x, stair2.y, humanList.get(i).x, humanList.get(i).y));
			}
		}
		
		Collections.sort(stairArray1);
		Collections.sort(stairArray2);
		
		int time1 = getEndTime(stairArray1, stair1.length);
		int time2 = getEndTime(stairArray2, stair2.length);
		
		return Math.max(time1, time2);
	}
	
	private static int getEndTime(List<Integer> stairArrayList, int stairLength) {
		/*
		 * 계단을 내려가는 시간
		 * - 계단을 내려가는 시간은 계단 입구에 도착한 후부터 계단을 완전히 내려갈 때까지의 시간이다.
		 * - 계단 입구에 도착하면, 1분 후 아래칸으로 내려 갈 수 있다.
		 * - 계단 위에는 동시에 최대 3명까지만 올라갈 수 있다.
		 * - 이미 계단을 3명이 내려가고 있는 경우, 그 중 한 명이 계단을 완전히 내려갈 때까지 계단 입구에서 대기해야 한다.
		 * - 계단마다 길이 K가 주어지며, 계단에 올라간 후 완전히 내려가는데 K분이 걸린다.
		 */
        if (stairArrayList.isEmpty()) return 0;

        // 현재 계단을 내려가고 있는 사람들의 "종료 시각"을 담는 최소 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int lastFinish = 0;

        for (int a : stairArrayList) {
            int earliestStart = a + 1; // 입구 도착 후 1분 뒤부터 계단 진입 가능

            // earliestStart 시점 이전/동시에 끝나는 사람들 제거 → 자리 비워짐
            while (!pq.isEmpty() && pq.peek() <= earliestStart) {
                pq.poll();
            }

            int startTime;
            if (pq.size() >= 3) {
                // 꽉 차있으면 가장 빨리 끝나는 사람 끝난 직후에 시작
                int earliestFree = pq.poll(); // 이 시각에 자리가 하나 남
                // 이 경우 arrival과 무관, 자리날 때부터 바로 탄다 (추가 대기 1분 없음)
                startTime = earliestFree;
            } else {
                // 자리가 있으면 도착+1 즉시 진입
                startTime = earliestStart;
            }

            int finishTime = startTime + stairLength;
            pq.offer(finishTime);
            lastFinish = Math.max(lastFinish, finishTime);
        }

        return lastFinish;
	}
	
	private static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
	
	private static class Human{
		int x;
		int y;
		
		Human(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	private static class Stair{
		int x;
		int y;
		int length;
		
		Stair(int x, int y, int length){
			this.x = x;
			this.y = y;
			this.length = length;
		}
		
	}

}
