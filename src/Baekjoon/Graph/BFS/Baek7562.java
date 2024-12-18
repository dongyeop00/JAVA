package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 나이트의 이동
체스판 위에 한 나이트가 놓여져 있다.
나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다.
나이트가 이동하려고 하는 칸이 주어진다.
나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?


입력
입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.

각 테스트 케이스는 세 줄로 이루어져 있다.
첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l × l이다.
체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다.
둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.


3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1
 */
public class Baek7562 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int startX, startY;
    static int arrX, arrY;
    static int l, count;
    public static void main(String[] arg) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(bf.readLine());

        for(int i=0; i<testCase; i++){
            l = Integer.parseInt(bf.readLine());

            count = 0;
            map = new int[l][l];
            visited = new boolean[l][l];

            // 나이트가 있는 칸
            st = new StringTokenizer(bf.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            // 나이트가 이동하려는 칸
            st = new StringTokenizer(bf.readLine());
            arrX = Integer.parseInt(st.nextToken());
            arrY = Integer.parseInt(st.nextToken());

            System.out.println(BFS());
        }
    }

    private static int BFS(){
        Queue<Horse> queue = new LinkedList<>();

        queue.offer(new Horse(startX, startY,1));
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            Horse horse = queue.poll();
            int currentX = horse.x;
            int currentY = horse.y;
            int currentMove = horse.move;

            if(currentX == arrX && currentY == arrY){
                return currentMove-1;
            }

            for(int i=0; i<8; i++){
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                if(newX == arrX && newY == arrY){
                    return currentMove;
                }

                if(newX >= 0 && newY >= 0 && newX < l && newY < l){
                    if(!visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.offer(new Horse(newX, newY, currentMove+1));
                    }
                }
            }
        }
        return -1;
    }

    private static class Horse{
        int x;
        int y;
        int move;
        Horse(int x, int y, int move){
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
}
