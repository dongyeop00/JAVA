package Baekjoon.HashMap;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class 전쟁_땅따먹기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase=0; testCase<T; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			int round = Integer.parseInt(st.nextToken());
			Map<Long, Integer> map = new HashMap();
			
			for(int i=0; i<round; i++) {
				Long num = Long.parseLong(st.nextToken());
				map.put(num, map.getOrDefault(num, 0)+1);
			}
			
			Long maxCountry = 0L;
			boolean war = true;
			
			for(Entry<Long, Integer> entrySet : map.entrySet()) {
				int current = entrySet.getValue();
				
				if((round / 2) < current) {
					war = true;
					maxCountry = entrySet.getKey();
					break;
				}else {
					war = false;
				}
			}
			
			if(war) {
				System.out.println(maxCountry);
			}else {
				System.out.println("SYJKGW");
			}
		}

	}

}
