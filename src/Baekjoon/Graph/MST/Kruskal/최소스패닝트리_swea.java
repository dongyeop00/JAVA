package Baekjoon.Graph.MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 최소스패닝트리_swea {

    static int V, E;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            List<Edge> list = new ArrayList<>();
            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                long weight = Long.parseLong(st.nextToken());
                list.add(new Edge(from, to, weight));
            }

            // 1. 간선 가중치 기준 오름차순 정렬
            Collections.sort(list);

            // 2. 유니온파인드 초기화
            long total = 0;
            int pick = 0;
            makeSet();

            // 3. 가중치 작은것부터 선택
            for(Edge e : list){
                if(unionSet(e.from, e.to)){
                    total += e.weight;
                    pick++;
                    if(pick == V-1) break;
                }
            }

            System.out.println("#" + testCase + " " + total);
        }
    }

    private static void makeSet(){
        parents = new int[V+1];
        for(int i=1; i<=V; i++){
            parents[i] = i;
        }
    }

    private static int findSet(int a){
        if(parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    private static boolean unionSet(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    private static class Edge implements Comparable<Edge>{
        int from;
        int to;
        long weight;

        Edge(int from, int to, long weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }
}
