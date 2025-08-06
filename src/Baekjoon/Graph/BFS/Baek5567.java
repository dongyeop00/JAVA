package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek5567 {

    static List<List<Integer>> graph = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int count = bfs(1);
        System.out.println(count);
    }

    public static int bfs(int x){
        Queue<Position> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int inviteCount = 0;

        queue.offer(new Position(x, 0));
        visited[x] = true;

        while(!queue.isEmpty()){
            Position current = queue.poll();
            int person = current.x;
            int depth = current.depth;

            if(depth >= 1 && depth <= 2){
                inviteCount++;
            }

            for(int node : graph.get(person)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.offer(new Position(node, depth + 1));
                }
            }
        }

        return inviteCount;
    }

    public static class Position {
        int x;
        int depth;

        Position(int x, int depth){
            this.x = x;
            this.depth = depth;
        }
    }
}
