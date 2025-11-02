package Baekjoon.달리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 지하철 {

    static int N, M;
    static int[] dist;
    static int[] prev;
    static int INF = 1_000_000_000;
    static List<Integer> path = new ArrayList<>();
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N];
        prev = new int[N];
        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int weight = Integer.parseInt(st.nextToken());
                if(i != j){
                    graph.get(i).add(new Node(j, weight));
                }
            }
        }

        int result = dijstra();
        System.out.println(result);
        for(int num : path) System.out.print(num+1 + " ");
    }

    public static int dijstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.offer(new Node(0, 0));
        dist[0] = 0;

        while(!queue.isEmpty()){
            Node current = queue.poll();

            if(dist[current.to] < current.weight) continue;

            for(Node next : graph.get(current.to)){
                if(dist[next.to] > dist[current.to] + next.weight){
                    dist[next.to] = dist[current.to] + next.weight;
                    prev[next.to] = current.to;
                    queue.offer(next);
                }
            }
        }

        for(int i=M-1; i!= -1; i=prev[i]){
            path.add(i);
        }

        Collections.reverse(path);

        return dist[M-1];
    }

    public static class Node implements Comparable<Node>{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
