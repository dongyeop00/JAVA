package Baekjoon.Graph.TopologySort; 

import java.util.*;
import java.io.*;

public class ACMCraft {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] time = new int[N+1];
			int[] line = new int[N+1];
			List<List<Integer>> graph = new ArrayList<>();
			for(int i=0; i<=N; i++) {
				graph.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph.get(from).add(to);
				line[to]++;
			}
			
			int W = Integer.parseInt(br.readLine());
			
			
			int[] dp = new int[N+1];
			Queue<Integer> queue = new LinkedList<>();
			
			//초기 건물 설정
			for(int i=1; i<=N; i++) {
				dp[i] = time[i];
				if(line[i] == 0) queue.offer(i);
			}

			while(!queue.isEmpty()) {
				int current = queue.poll();
				
				for(int next : graph.get(current)) {
					line[next]--;
					
					dp[next] = Math.max(dp[next], dp[current] + time[next]);
					
					if(line[next] == 0) queue.offer(next);
				}
			}
			System.out.println(Arrays.toString(dp));
			System.out.println(dp[W]);
		}
	}

}
