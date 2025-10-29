package Baekjoon.달리기;

import java.io.*;

public class 정식이의은행업무 {

	static String[] two, three;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			two = br.readLine().split("");
			three = br.readLine().split("");
			
			for(int i=0; i<two.length; i++) {
				if(two[i].equals("0")) {
					two[i] = "1";
				}else {
					two[i] = "0";
				}
				
				for(int j=0; j<three.length; j++) {
					boolean zero = false;
					boolean one = false;
					boolean two = false;
					
					if(three[j].equals("0")) {
						zero = true;
					}else if(three[j].equals("1")) {
						one = true;
					}else {
						two = true;
					}
					
					if(zero) {
						three[j] = "1";
						print(testCase);
						three[j] = "2";
						print(testCase);
						three[j] = "0";
					}else if(one) {
						three[j] = "0";
						print(testCase);
						three[j] = "2";
						print(testCase);
						three[j] = "1";
					}else {
						three[j] = "0";
						print(testCase);
						three[j] = "1";
						print(testCase);
						three[j] = "2";
					}
				}
				
				if(two[i].equals("0")) {
					two[i] = "1";
				}else {
					two[i] = "0";
				}
			}
		}
	}
	
	static void print(int testCase) {
		String temp1 = String.join("", two);
		String temp2 = String.join("", three);
		
		int a = Integer.parseInt(temp1,2);
		int b = Integer.parseInt(temp2,3);
		
		if(a == b) {
			System.out.println("#" + testCase + " " + a);
			return;
		}

	}

}
