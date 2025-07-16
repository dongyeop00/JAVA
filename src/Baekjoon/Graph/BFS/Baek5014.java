package Baekjoon.Graph.BFS;

import java.util.*;
import java.io.*;

public class Baek5014 {

    static int F, S, G, U, D;
    static int[] visited; // 해당 칸에 몇번째 들어왔는지

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        F = Integer.parseInt(stringTokenizer.nextToken()); // 건물 층수
        S = Integer.parseInt(stringTokenizer.nextToken()); // 강호 위치
        G = Integer.parseInt(stringTokenizer.nextToken()); // 스타트링크 위치		G<=F<=1,000,000
        U = Integer.parseInt(stringTokenizer.nextToken()); // 위로 갈 수 있는 칸
        D = Integer.parseInt(stringTokenizer.nextToken()); // 아래로 갈 수 있는 칸	D <= 1,000,000
        visited = new int[F+1];

        int result = BFS(S);

        if(S == G) {
            System.out.println(0);
            return;
        }

        if(result == -1) {
            System.out.println("use the stairs");
        }else {
            System.out.println(result);
        }
    }

    public static int BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = 1;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            if(current == G) {
                return visited[current]-1;
            }

            int up = current + U;
            int down = current - D;

            if(up <= F && visited[up] == 0) {
                visited[up] = visited[current] + 1;
                queue.offer(up);
            }

            if( down >= 1 && visited[down] == 0) {
                visited[down] = visited[current] + 1;
                queue.offer(down);
            }

        }

        return -1;
    }

}
