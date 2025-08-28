package Baekjoon.모의SW역량테스트;

import java.util.*;
import java.io.*;

public class 특이한자석 {
	
	static BufferedReader br;
	static StringTokenizer st;
	static boolean[][] magnet;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=TC; testCase++) {
			int K = Integer.parseInt(br.readLine());
			setMagnet();

			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				// 방향 측정
				checkDir(num, dir);
			}
			
			System.out.println("#" + testCase + " " + Count());
		}
	}
	
	private static void checkDir(int num, int dir) {
	    int index = num - 1;              // 입력은 1~4, 배열은 0~3
	    int[] dirs = new int[4];        // 각 자석 회전 방향: -1(반시계), 0(정지), 1(시계)
	    dirs[index] = dir;

	    // 왼쪽으로 전파
	    for (int i = index - 1; i >= 0; i--) {
	        if (magnet[i][2] != magnet[i+1][6]) {
	            dirs[i] = -dirs[i+1]; // 서로 다르면 반대 방향
	        } else {
	            break;
	        }
	    }

	    // 오른쪽으로 전파
	    for (int i = index + 1; i < 4; i++) {
	        if (magnet[i - 1][2] != magnet[i][6]) {
	            dirs[i] = -dirs[i - 1]; // 서로 다르면 반대 방향
	        } else {
	            break;
	        }
	    }

	    // 계산된 방향대로 실제 회전 적용
	    for (int i = 0; i < 4; i++) {
	        if (dirs[i] != 0) {
	        	rotateMagnet(i, dirs[i]);
	        }
	    }
	}
	
	private static void rotateMagnet(int i, int dir) {
		if(dir == -1) {
			boolean temp = magnet[i][0];
			for(int j=1; j<8; j++) {
				magnet[i][j-1] = magnet[i][j];
			}
			magnet[i][7] = temp;
		}else if(dir == 1) {
			boolean temp = magnet[i][7];
			for(int j=6; j>=0; j--) {
				magnet[i][j+1] = magnet[i][j];
			}
			magnet[i][0] = temp;
		}
	}
	
	private static void setMagnet() throws IOException {
		
		magnet = new boolean[4][8];
		
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<8; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 0) magnet[i][j] = false;
				else magnet[i][j] = true;
			}
		}
	}
	
	private static int Count() {
		int count = 0;
		
		for(int i=0; i<4; i++) {
			if(magnet[i][0] == false) count += 0;
			else if(i == 0 && magnet[i][0] == true) count += 1;
			else if(i == 1 && magnet[i][0] == true) count += 2;
			else if(i == 2 && magnet[i][0] == true) count += 4;
			else if(i == 3 && magnet[i][0] == true) count += 8;
		}
		
		return count;
	}
	
	private static void display() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(magnet[i][j] + " ");
			}
			System.out.println();
		}
	}

}
