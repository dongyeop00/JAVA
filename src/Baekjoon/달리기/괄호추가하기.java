package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 괄호추가하기 {

	static int N, max;
	static String[] str;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		str = br.readLine().split("");
		max = Integer.MIN_VALUE;
		
		dfs(0, Integer.parseInt(str[0]));
		System.out.println(max);
	}
	
	public static void dfs(int index, int sum) {
		if(index == N-1) {
			max = Math.max(max, sum);
			return;
		}
		
		// 1. 괄호를 맨 앞에다 치는 경우
		int result = calc(sum, str[index+1], Integer.parseInt(str[index+2]));
		dfs(index+2, result);
		
		// 2. 괄호를 바로 뒤에다 치는 경우
		if(index+4 < N) {
			int temp = calc(
					Integer.parseInt(str[index+2]),
					str[index+3], 
					Integer.parseInt(str[index+4]));
			
			// 현재랑 temp랑 연결
			// 3+(8*7)-9*2 -> 3+56-9*2
			result = calc(sum, str[index+1], temp);
			
			dfs(index+4, result);
		}
	}
	
	public static int calc(int num1, String operator, int num2) {
		if(operator.equals("+")) {
			return num1+num2;
		}else if(operator.equals("-")) {
			return num1-num2;
		}else {
			return num1*num2;
		}
	}
}
