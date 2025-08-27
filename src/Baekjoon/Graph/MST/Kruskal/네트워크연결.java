package Baekjoon.Graph.MST.Kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 네트워크연결 {

    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>(E);
        for(int i=0; i<E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, weight));
        }

        // 1) 간선 가중치 오름차순 정렬
        Collections.sort(edges);

        // 2) 유니온-파인드 초기화
        make(V);

        // 3) 작은 간선부터 채택
        long total = 0;
        int picked = 0;
        for(Edge e : edges){
            if(union(e.from, e.to)){
                total += e.weight;
                picked++;
                if(picked == V-1) break; // MST 완성
            }
        }

        System.out.println(total);
    }

    static void make(int V){
        parent = new int[V+1];
        for(int i=1; i<=V; i++){
            parent[i] = i;
        }
    }

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    }

    // rank/size 없이: 루트 번호가 작은 쪽을 부모로
    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        if(a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }
    }
}