package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 단지 번호 붙이기
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다.
<그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고,
각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

입력
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

출력
3
7
8
9

 */
public class 단지번호붙이기 {
	
	static int N, houseCount;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
        	String str = bufferedReader.readLine();
        	for(int j=0; j<N; j++) {
        		map[i][j] = str.charAt(j) - '0';
        	}
        }
        
        // 집 수
        houseCount = 1;
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(!visited[i][j] && map[i][j] != 0) {
        			DFS(i, j);
        			list.add(houseCount);
        			houseCount = 1;
        		}
        	}
        }
        
        System.out.println(list.size());
        Collections.sort(list);
        for(int num : list) System.out.println(num);
    }
    
    public static void DFS(int x, int y) {
    	visited[x][y] = true;
    	
    	for(int i=0; i<4; i++) {
    		int newX = x + dx[i];
    		int newY = y + dy[i];
    		
    		if(newX < 0 || newY < 0 || newX >=N || newY >= N) continue;
    		if(visited[newX][newY]) continue;
    		if(map[newX][newY] != 1) continue;
    		
    		DFS(newX, newY);
    		houseCount++;
    	}
    }

}



























