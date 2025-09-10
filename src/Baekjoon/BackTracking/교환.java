package Baekjoon.BackTracking;

import java.util.*;
import java.io.*;

public class 교환 {

	static int N, K;
	static int result = -1;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		BFS();
		System.out.println(result);
	}

	public static void BFS() {
		Queue<Number> queue = new LinkedList<>();
		boolean[][] visited = new boolean[1000001][K+1];
		
		queue.offer(new Number(N, 0));
		visited[N][0] = true;
		
		while(!queue.isEmpty()) {
			Number current = queue.poll();
			
			if(current.cnt == K) {
				result = Math.max(result, current.num);
				continue;
			}
			
			int length = String.valueOf(N).length();
			
			for(int i=0; i<length-1; i++) {
				for(int j=i+1; j<length; j++) {
					int swap = SWAP(current.num, i, j);
					
					if(swap != -1 && !visited[swap][current.cnt + 1]) {
						queue.offer(new Number(swap, current.cnt+1));
						visited[swap][current.cnt+1] = true;
					}
				}
			}
		}
	}
	
	public static int SWAP(int num, int i, int j) {
		char[] numArray = String.valueOf(num).toCharArray();

		// 맨 앞자리가 0이면 안됨
		if(i == 0 && numArray[j] == '0') {
			return -1;
		}
		
		char temp = numArray[i];
		numArray[i] = numArray[j];
		numArray[j] = temp;
		
		return Integer.parseInt(new String(numArray));
	}
	
	public static class Number{
		int num;
		int cnt;
		
		Number(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}
