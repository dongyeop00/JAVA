package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE {

    static int N, M;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        visited = new boolean[N];
        found = false;

        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int i=0; i<N; i++){
            visited[i] = true;
            dfs(1, i);
            visited[i] = false;

            if(found) break;
        }

        System.out.println(found ? 1 : 0);
    }

    public static void dfs(int depth, int node){
        if(depth == 5){
            found = true;
            return;
        }

        for(int next : graph.get(node)){
            if(!visited[next]) {
                visited[next] = true;
                dfs(depth + 1, next);
                visited[next] = false;
            }
        }
    }
}
