package Baekjoon.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 창용마을무리의개수 {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parents = new int[N+1];

            make();

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a,b);
            }

            Set<Integer> set = new HashSet<>();
            for(int i=1; i<=N; i++){
                set.add(find(i));
            }

            System.out.println("#" + testCase + " " + set.size());
        }
    }

    public static void make(){
        for(int i=0; i<=N; i++){
            parents[i] = i;
        }
    }

    public static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return;

        parents[bRoot] = aRoot;
    }
}
