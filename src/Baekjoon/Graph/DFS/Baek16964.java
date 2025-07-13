package Baekjoon.Graph.DFS;

import java.io.*;
import java.util.*;

public class Baek16964 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] answer;
    static boolean[] visited;
    static boolean flag;
    static int index;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());

        answer = new int[N];
        visited = new boolean[N+1];
        flag = true;
        index = 1;

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i< N-1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=0; i<N; i++) {
            answer[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        DFS(1);

        if(flag) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    public static void DFS(int node) {
        if(visited[node]) return;

        visited[node] = true;

        HashSet<Integer> set = new HashSet<>();

        for(int next : graph.get(node)) {
            if(visited[next]) continue;
            set.add(next);
        }

        if(set.isEmpty()) return;

        if(set.contains(answer[index])) {
            DFS(answer[index++]);
        }else {
            flag = false;
        }
    }
}