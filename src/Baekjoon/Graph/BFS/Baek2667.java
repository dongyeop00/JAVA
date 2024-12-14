package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

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
public class Baek2667 {

    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> countList = new ArrayList<>();
    static int[] dx = { -1 , 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, count;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N;i++){
            String str = bufferedReader.readLine();
            for(int j=0; j<N; j++){
                char c = str.charAt(j);
                map[i][j] = c - '0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    BFS(i,j);
                    countList.add(count);
                }
            }
        }

        Collections.sort(countList);

        System.out.println(countList.size());

        for(int i=0; i<countList.size(); i++){
            System.out.println(countList.get(i));
        }
    }

    private static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        count = 0;

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int currentX = node[0];
            int currentY = node[1];
            count++;

            for(int i=0; i<4; i++){
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                if(newX >=0 && newY >= 0 && newX<N && newY<N){
                    if(map[newX][newY] == 1 && !visited[newX][newY]){
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }
}
