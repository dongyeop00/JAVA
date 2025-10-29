package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 재관이의대량할인 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int sum = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i] = temp;
				sum += temp;
			}
			
			Arrays.sort(arr);
			int count = 0;
			int discount = 0;
			
			for(int i=N-1; i>=0; i--) {
				count++;
				if(count == 3) {
					discount += arr[i];
					count = 0;
				}
			}
			
			int result = sum - discount;
			System.out.println("#" + testCase + " " + result);
			
		}

	}

}
