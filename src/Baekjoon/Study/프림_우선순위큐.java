package Baekjoon.Study;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 프림_우선순위큐 {

    static List<List<Edge>> graph = new ArrayList<>();

    static int N = 7;

    public static void main(String[] args) {
        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }

        setGraph();

        boolean[] visited = new boolean[N];
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        int total = 0;
        int pick = 0;

        // 프림 알고리즘
        // 임의 점(0번) 선택과 0번과 이어져있는 간선 큐에 넣기
        visited[0] = true;
        for(Edge e : graph.get(0)){
            queue.offer(e);
        }

        // 반복
        // 큐가 빌 때까지 && 간선은 V-1개까지
        while(!queue.isEmpty() && pick < N-1){
            Edge current = queue.poll();

            // 도착할 간선이 선택되지 않았다면
            if(!visited[current.to]){
                visited[current.to] = true;
                total += current.weight;
                pick++;

                // 다음 간선이랑 연결된 정점 넣기
                for(Edge e : graph.get(current.to)){
                    queue.offer(e);
                }
            }
        }

        System.out.println(total);
    }


    static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        // weight 기준 오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }


    static void addUndirected(int u, int v, int w) {
        graph.get(u).add(new Edge(v, w));
        graph.get(v).add(new Edge(u, w));
    }

    // 주어진 map 값들을 그대로 반영해 인접리스트 구성
    static void setGraph() {
        addUndirected(0, 1, 2);
        addUndirected(0, 2, 4);
        addUndirected(0, 5, 8);
        addUndirected(1, 2, 1);
        addUndirected(1, 3, 19);
        addUndirected(2, 5, 5);
        addUndirected(3, 5, 11);
        addUndirected(3, 4, 7);
        addUndirected(3, 6, 15);
        addUndirected(4, 6, 3);
        addUndirected(5, 4, 9);
    }

}

