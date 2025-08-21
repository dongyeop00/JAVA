package Baekjoon.Graph.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 작업순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int testCase=1; testCase<=10; testCase++){
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<List<Integer>> graph = new ArrayList<>();
            int[] line;

            for(int i=0; i<=V; i++){
                graph.add(new ArrayList<>());
            }

            line = new int[V+1];

            st = new StringTokenizer(br.readLine());

            for(int i=0; i<E; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                line[to]++;
            }

            Queue<Integer> queue = new LinkedList<>();

            for(int i=1; i<=V; i++){
                if(line[i] == 0) queue.offer(i);
            }

            System.out.print("#" + testCase + " ");
            while(!queue.isEmpty()){
                int current = queue.poll();
                System.out.print(current + " ");

                for(int next : graph.get(current)){
                    line[next]--;

                    if(line[next] == 0){
                        queue.offer(next);
                    }
                }
            }
        }
    }
}
