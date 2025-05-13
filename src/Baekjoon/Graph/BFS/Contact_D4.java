package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Contact_D4 {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        for(int test_case = 1; test_case <= 10; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int length = Integer.parseInt(stringTokenizer.nextToken());
            int start = Integer.parseInt(stringTokenizer.nextToken());

            // 그래프 초기화
            graph = new ArrayList<>();
            for(int i=0; i<=100; i++){
                graph.add(new ArrayList<>());
            }

            visited = new boolean[101];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<length/2; i++){
                int from = Integer.parseInt(stringTokenizer.nextToken());
                int to = Integer.parseInt(stringTokenizer.nextToken());

                graph.get(from).add(to);
            }

            int result = BFS(start);
            System.out.println("#" + test_case + " " + result);
        }
    }

    private static int BFS(int node){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);
        visited[node] = true;
        int max = 0;
        int size = 0;

        while(!queue.isEmpty()){
            max = 0;
            size = queue.size();
            for(int i=0; i<size; i++){
                int current = queue.poll();
                max = Math.max(max, current);
                for(int num : graph.get(current)){
                    if(!visited[num]){
                        visited[num] = true;
                        queue.add(num);
                    }
                }
            }
        }
        return max;

    }
}
