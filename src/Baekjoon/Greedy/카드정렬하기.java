package Baekjoon.Greedy;

import java.io.*;
import java.util.*;

public class 카드정렬하기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			queue.offer(Integer.parseInt(br.readLine()));
		}

		long answer = 0;
		
		while(queue.size() > 1) {
			int a = queue.poll();
			int b = queue.poll();
			int c = a + b;
			answer += c;
			queue.offer(c);
		}
		
		System.out.println(answer);
		
	}

}
