package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek11724 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int N, M,count;

    public static void main(String[] arg) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());

       visited = new boolean[N+1];

       for(int i=0; i<N+1; i++){
           graph.add(new ArrayList<>());
       }

       for(int i=0; i<M; i++){
           st = new StringTokenizer(bf.readLine());

           int x = Integer.parseInt(st.nextToken());
           int y = Integer.parseInt(st.nextToken());

           graph.get(x).add(y);
           graph.get(y).add(x);
       }

       for(int i=1; i<N+1; i++){
           if(!visited[i]){
               BFS(i);
               count++;
           }
       }
       System.out.println(count);
    }

    private static void BFS(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int i=0; i<graph.get(current).size(); i++){
                int node = graph.get(current).get(i);

                if (!visited[node]){
                    queue.offer(node);
                    visited[node] = true;
                }
            }
        }
    }
}
