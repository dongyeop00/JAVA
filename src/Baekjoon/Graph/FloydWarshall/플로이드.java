package Baekjoon.Graph.FloydWarshall;

import java.util.*;
import java.io.*;

// 플로이드 워샬의 핵심
// 1. dist[i][i] = 0, 자기 자신은 0으로 초기화
// 2. 입력 간선의 최솟값으로 dist[a][b] 세팅 (중복 간선 처리)
// 3. dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j])로 업데이트

public class 플로이드 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] dist = new int[N+1][N+1];
		int INF = 1_000_000_000;
		
		for(int i=1; i<N+1; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}	
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(weight < dist[a][b]) {
				dist[a][b] = weight;
			}
		}
		

		
		for(int k=1; k<N+1; k++) {
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(dist[i][j] == INF) {
					System.out.print(0 + " ");
				}else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

}
