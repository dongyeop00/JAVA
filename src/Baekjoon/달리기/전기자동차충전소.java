package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 전기자동차충전소 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase=0; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			Home[] homes = new Home[N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				homes[i] = new Home(x, y, d);
			}
			
			int result = Integer.MAX_VALUE;
			
			for(int x=-15; x<=15; x++) {
				for(int y=-15; y<=15; y++) {
					boolean flag = true;
					int sum = 0;
					
					for(int i=0; i<N; i++) {
						int dist = getDistance(x, y, homes[i].x, homes[i].y);
						
						// 충전소가 집 범위 밖에 있거나 || 거리가 0인 곳(집이랑 충전소 위치가 같음)
						if(homes[i].d < dist || dist == 0) {
							flag = false;
							break;
						}
						
						sum += dist;
					}
					
					if(flag) {
						result = Math.min(result, sum);
					}
				}
			}
			
			if(result != Integer.MAX_VALUE) {
				System.out.println("#" + testCase + " " + result);
				continue;
			}
			
			for(int x1=-15; x1<=15; x1++) {
				for(int y1=-15; y1<=15; y1++) {
					for(int x2=-15; x2<=15; x2++) {
						for(int y2=-15; y2<=15; y2++) {
							boolean flag = true;
							int sum = 0;
							
							for(int i=0; i<N; i++) {
								int dist1 = getDistance(x1, y1, homes[i].x, homes[i].y);
								int dist2 = getDistance(x2, y2, homes[i].x, homes[i].y);
								int min = Math.min(dist1, dist2);
								
								if(homes[i].d < min || min == 0) {
									flag = false;
									break;
								}
								
								sum += min;
							}
							
							if(flag) {
								result = Math.min(result, sum);
							}
						}
					}
				}
			}
			
			if(result != Integer.MAX_VALUE) {
				System.out.println("#" + testCase + " " + result);
			}else {
				System.out.println("#" + testCase + " " + -1);
			}
		}
		
	}
	
	static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
	
	static class Home{
		int x;
		int y;
		int d;
		
		Home(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

}
