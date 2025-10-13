package Baekjoon.Preprocessing;

import java.util.*;
import java.io.*;

public class 좌표압축 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 증복 제거
		Set<Integer> set = new HashSet<>();
		for(int num : arr) {
			set.add(num);
		}
		
		// 리스트로 변환
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		
		
		// 값 -> 인덱스 매핑 생성
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<list.size(); i++) {
			map.put(list.get(i), i);
		}
		
		// 압축 값 반환
		for(int i=0; i<arr.length; i++) {
			arr[i] = map.get(arr[i]);
		}
		
		StringBuilder sb = new StringBuilder(); 
		for(int num : arr) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);
	}

}
