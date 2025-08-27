package Baekjoon.Graph.MST.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 하나로 {

    static int N;
    static int[] parents;
    static int[][] array;
    static List<Edge> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            N = Integer.parseInt(br.readLine());

            array = new int[N][N];
            list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                array[i][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                array[i][1] = Integer.parseInt(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());

            for(int i=0; i<N-1; i++){
                for(int j=i+1; j<N; j++){
                    long x = array[i][0] - array[j][0];
                    long y = array[i][1] - array[j][1];
                    long dist = x*x + y*y;
                    list.add(new Edge(i, j, dist));
                }
            }

            // 1. 간선 가중치 기준 오름차순 정렬
            Collections.sort(list);

            // 2. 유니온파인드 초기화
            makeSet();

            // 3. 작은 간선부터 채택
            long total = 0;
            int pick = 0;
            for(Edge e : list){
                if(unionSet(e.from, e.to)){
                    total += e.weight;
                    pick++;
                    if(pick == N-1) break;
                }
            }

            System.out.println("#" + testCase + " " + Math.round(total * E));
        }
    }

    public static void makeSet(){
        parents = new int[N+1];
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }
    }

    public static int findSet(int a){
        if(parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean unionSet(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static class Edge implements Comparable<Edge>{
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
