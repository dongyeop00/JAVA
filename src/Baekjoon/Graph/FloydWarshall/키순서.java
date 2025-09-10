package Baekjoon.Graph.FloydWarshall;

import java.util.*;
import java.io.*;

public class 키순서 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			boolean[][] dist = new boolean[N+1][N+1];
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				dist[a][b] = true;
			}
			
			for (int k = 1; k <= N; k++) {
			    for (int i = 1; i <= N; i++) {
			        for (int j = 1; j <= N; j++) {
			            if (dist[i][k] && dist[k][j]) dist[i][j] = true;
			        }
			    }
			}

			
			int answer = 0;
			for(int i=1; i<N+1; i++) {
				int know = 0;
				for(int j=1; j<N+1; j++) {
					if(i == j) continue;
					if(dist[i][j] || dist[j][i]) know++;
				}
				if(know == N-1) answer++;
			}
			
			System.out.println("#" + testCase + " " + answer);
		}
	}

}
