package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 보물상자비밀번호 {
	
	// N개의 수 중 계속 회전시켜 생성 가능한 수 중 K번째 큰 수
	static int N, K;
	static String str;
	static TreeSet<Integer> set;
	static List<Integer> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			set = new TreeSet<>();
			list = new ArrayList<>();
			
			str = br.readLine();
			
			// 회전 수
			int spin = N / 4;
			for(int i=0; i<spin; i++) {
				// 먼저 회전
				str = str.substring(str.length()-1, str.length()) + str.substring(0, str.length()-1);
				String temp = str;
				
				// 4개씩 자르기
				for(int j=0; j<temp.length(); j+=spin) {
					String value = temp.substring(j, j+spin);
					// 16 -> 10 변환
					int num = Integer.parseInt(value, 16);
					set.add(num);
				}
			}
			
			for(int num : set) {
				list.add(num);
			}
			
			Collections.sort(list, Collections.reverseOrder());
			System.out.println("#" + testCase + " " + list.get(K-1));
		}

	}

}
