package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek5568 {
    static int[] map, answer;
    static boolean[] visited;
    static int N, K;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());
        K = Integer.parseInt(bufferedReader.readLine());

        map = new int[N];
        visited = new boolean[N];
        answer = new int[K];
        set = new HashSet<>();

        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(bufferedReader.readLine());
        }

        backTracking(0);
        System.out.println(set.size());
    }

    private static void backTracking(int depth){
        if(depth == K){
            StringBuilder stringBuilder = new StringBuilder();

            for(int num : answer){
                stringBuilder.append(num);
            }

            String result = stringBuilder.toString();
            set.add(result);
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = map[i];
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }
}
