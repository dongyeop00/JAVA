package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 길찾기_D4 {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        for(int test_case=0; test_case<10; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int T = Integer.parseInt(stringTokenizer.nextToken());
            int length = Integer.parseInt(stringTokenizer.nextToken());

            //그래프 초기화
            graph = new ArrayList<>();
            for(int i=0; i<99; i++){
                graph.add(new ArrayList<>());
            }

            //방문배열 초기화
            visited = new boolean[100];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<length; i++){
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());

                graph.get(x).add(y);
            }

            result = 0;
            DFS(0);
            System.out.println("#" + T + " " + result);
        }
    }

    private static void DFS(int v){

        if(v == 99){
            result = 1;
            return;
        }

        visited[v] = true;

        for(int i=0; i<graph.get(v).size(); i++){
            int node = graph.get(v).get(i);
            if(!visited[node]){
                DFS(node);
            }
        }
    }
}
