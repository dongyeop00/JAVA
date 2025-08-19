package Baekjoon.Combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 게리맨더링 {

    static int N, min = Integer.MAX_VALUE, count = 0;
    static int[] people;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());

        people = new int[N+1];
        visited = new boolean[N+1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=1; i<=N; i++){
            people[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int num = Integer.parseInt(stringTokenizer.nextToken());
            for(int j=0; j<num; j++){
                int x = Integer.parseInt(stringTokenizer.nextToken());

                graph.get(i).add(x);
            }
        }

        subset(1, visited);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void subset(int index, boolean[] visited){
        if(index == N+1){
            check(visited);
            return;
        }

        // 선택
        visited[index] = true;
        subset(index+1, visited);

        // 미선택
        visited[index] = false;
        subset(index+1, visited);
    }

    public static void check(boolean[] visited){
        int Acnt = 0, Bcnt = 0;

        for(int i=1; i<=N; i++){
            if(visited[i]) Acnt++;
            else Bcnt++;
        }

        if(Acnt == 0 || Bcnt == 0) return;

        int A = bfs(Acnt, true);
        if(A < 0) return;
        int B = bfs(Bcnt, false);
        if(B < 0) return;

        min = Math.min(min, Math.abs(A - B));
    }

    public static int bfs(int size, boolean condition){
        boolean[] check = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();

        int start = -1;
        for(int i=1; i<=N; i++){
            if(visited[i] == condition){
                start = i;
                break;
            }
        }

        if(start == -1){
            return -1;
        }

        queue.add(start);
        check[start] = true;
        int visitedCount = 0;
        int sum = 0;

        while(!queue.isEmpty()){
            int current = queue.poll();
            visitedCount++;
            sum += people[current];

            for(int next : graph.get(current)){
                if(!check[next] && visited[next] == condition){
                    check[next] = true;
                    queue.offer(next);
                }
            }
        }

        return (visitedCount == size) ? sum : -1;
    }
}
