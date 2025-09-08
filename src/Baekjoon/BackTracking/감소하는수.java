package Baekjoon.BackTracking;

import java.util.*;
import java.io.*;

public class 감소하는수 {
	
	static List<Long> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 9;
		
		// 조건 :  0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다. 따라서 10미만 수는 그대로 출력
		if(N < 10) {
			System.out.println(N);
			return;
		}
		// 감소하는 수를 구하니 1023개가 나옴 따라서 1024번째 감소하는 수를 구하는 건 없음. 따라서 -1을 출력
		else if(N >= 1023) {
			System.out.println(-1);
			return;
		}
			
		for(int i=0; i<10; i++) {
			search(1, i);
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(N));
	}
	
	public static void search(int index, long number) {
		if(index > 10) return;
		
		list.add(number);
		
		// number가 4일 때 뒤에 붙일 수 있는 수는 0~3까지 따라서 현재 숫자의 %10한 값까지 붙인다.
		for(int i=0; i< number % 10; i++) {
			search(index+1, number * 10 + i);
		}
	}
}
