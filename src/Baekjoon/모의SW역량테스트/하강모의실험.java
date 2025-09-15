package Baekjoon.모의SW역량테스트;

import java.util.Arrays;
import java.util.Scanner;

public class 하강모의실험 {
	static int T, Ans, N;
	static int[][] map;

	public static void main(String[] args) {
		System.setIn(하강모의실험.class.getResourceAsStream("하강모의실험.txt"));
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			N = sc.nextInt();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// row
			for (int C = 0; C < N; C++) {
				if (map[0][C] == 0) continue;
				
				int curR = 0; // 떨어지는 선두 박스의 현재 행 인덱스
				int curBox = 1; // 떨어지는 박스의 덩어리 수
				double curForce = 1;
				
				// 바닥까지 하향을 시킨다
				// 덩어리의 아랫면 = curR + curBox - 1
				// 아랫면의 바로 아래 칸 = curR + curBox
				while (curR + curBox < N) { // 아랫면 아래 칸이 격자 범위 안에 있으면

					// 박스에 부디치면
					if (map[curR + curBox][C] == 1) {
						
						// 부디치는 박스크기를 구한다
						int resistBox = curR + curBox;
						while (resistBox < N && map[resistBox][C] == 1) {
							resistBox++;
						}
						// 부디치는 박스의 총 크기
						resistBox = resistBox - (curR + curBox);
						
						// 떨어지는 힘이 더 크면 같이 떨어지고
						if (curForce > resistBox) {
							curBox += resistBox;
							curForce += resistBox;
						} else {
							// 더 작으면 거기서 정지한다
							break;
						}
					}

					// 지도에 박스를 한칸내린다
					// 밑장빼기
					if (curR + curBox < N) {
						map[curR][C] = 0;
						map[curR + curBox][C] = 1;
					}

					curForce *= 1.9;
					
					// 한칸 밑으로 내린다
					curR++;
				}
			}
//			print(map);
			// col
			for (int R = 0; R < N; R++) {
				if (map[R][0] == 0)
					continue;
				
				int curC = 0;
				int curBox = 1;
				double curForce = 1;
				// 바닥까지 하향을 시킨다
				while (curC + curBox < N) {
					
					// 박스에 부디치면
					if (map[R][curC + curBox] == 1) {
						// 부디치는 박스크기를 구한다
						int resistBox = curC + curBox;
						while (resistBox < N && map[R][resistBox] == 1)
							resistBox++;
						resistBox -= curC + curBox;
						// 떨어지는 힘이 더 크면 같이 떨어지고
						if (curForce > resistBox) {
							curBox += resistBox;
							curForce += resistBox;
						} else {
							// 더 작으면 거기서 정지한다
							break;
						}
					}
					// 지도에 박스를 한칸내린다					
					if (curC + curBox < N) {
						map[R][curC] = 0;
						map[R][curC + curBox] = 1;
					}
					curForce *= 1.9;
					
					// 한칸 밑으로 내린다
					curC++;
				}

			}

			//print(map);
			int sumR = 0;
			int sumC = 0;
			for (int i = 0; i < N; i++) {
				if (map[N - 1][i] == 1)
					sumR++;
				if (map[i][N - 1] == 1)
					sumC++;
			}

			System.out.printf("#%d %d %d\n", tc, sumR, sumC);
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

}
