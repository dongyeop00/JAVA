package Baekjoon.Combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 게리맨더링_DFS {

    static int N, min = Integer.MAX_VALUE;
    static int[] people;
    static boolean[] selected;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        people = new int[N+1];
        selected = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());
            for(int j=0; j<count; j++){
                int num = Integer.parseInt(st.nextToken());

                graph.get(i).add(num);
            }
        }

        subset(1, selected);

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }

    public static void subset(int depth, boolean[] selected){
        if(depth == N+1){
            check(selected);
            return;
        }

        // 선택
        selected[depth] = true;
        subset(depth+1, selected);

        // 미선택
        selected[depth] = false;
        subset(depth+1, selected);
    }

    public static void check(boolean[] selected){
        int Acnt=0, Bcnt=0;

        for(int i=1; i<=N; i++){
            if(selected[i]) Acnt++;
            else Bcnt++;
        }

        if(Acnt == 0 || Bcnt == 0) return;

        int A = DFScheck(Acnt, true);
        if(A < 0) return;
        int B = DFScheck(Bcnt, false);
        if(B < 0) return;

        min = Math.min(min, Math.abs(A-B));
    }

    public static int DFScheck(int team, boolean condition){
        boolean[] visited = new boolean[N+1];

        int start = -1;
        for(int i=1; i<=N; i++){
            if(selected[i] == condition){
                start = i;
                break;
            }
        }

        if(start == -1) {
            return -1;
        }

        // 0번째 인덱스 : 값, 1번째 인덱스 : 팀수(체크용)
        int[] result = new int[2];
        DFS(start, condition, visited, result);

        return result[1] == team ? result[0] : -1;
    }

    public static void DFS(int x, boolean condition, boolean[] visited, int[] result){
        visited[x] = true;
        result[0] += people[x];
        result[1]++;

        for(int next : graph.get(x)){
            if(!visited[next] && selected[next] == condition){
                visited[next] = true;
                DFS(next, condition, visited, result);
            }
        }
    }
}
