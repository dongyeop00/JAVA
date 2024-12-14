package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 미로 탐색
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다.
칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다.
다음 N개의 줄에는 M개의 정수로 미로가 주어진다.
각각의 수들은 붙어서 입력으로 주어진다.
4 6
101111
101010
101011
111011

출력
15
 */
public class Baek2178_class {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, count;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=1; i<N+1; i++){
            String str = bufferedReader.readLine();
            for(int j=1; j<M+1; j++){
                char c = str.charAt(j-1);
                map[i][j] = c - '0';
            }
        }

        System.out.println(BFS());

    }

    private static int BFS(){
        Queue<spot> queue = new LinkedList<>();

        queue.offer(new spot(1,1,1));
        visited[0][0] = true;
        count = 1;

        while(!queue.isEmpty()){
            spot s = queue.poll();
            int currentX = s.x;
            int currentY = s.y;
            int currentDist = s.dist;

            for(int i=0; i<4; i++){
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                if(newX == N && newY == M){
                    return currentDist+1;
                }

                if(newX >= 0 && newY >= 0 && newY <= M && newX <= N){
                    if(map[newX][newY] == 1 && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        queue.offer(new spot(newX, newY, currentDist+1));
                    }
                }
            }
        }
        return -1;
    }
}


class spot{
    int x;
    int y;
    int dist;
    spot(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
