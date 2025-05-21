package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2529 {
    static String[] map;
    static boolean[] visited;
    static int[] num, answer;
    static int K;
    static String max, min;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        K = Integer.parseInt(bufferedReader.readLine());
        map = new String[K];
        answer = new int[K+1];
        visited = new boolean[10];
        num = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        max = "";
        min = "";

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<K; i++){
            map[i] = stringTokenizer.nextToken();
        }

        backTracking(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void backTracking(int depth){
        if(depth == K+1){
            flag = false;
            for(int i=0; i<K; i++){
                String temp = map[i];

                if(temp.equals("<")){
                    if(answer[i] < answer[i+1]){
                        flag = true;
                    }else{
                        return;
                    }
                }else{
                    if(answer[i] > answer[i+1]){
                        flag = true;
                    }else{
                        return;
                    }
                }
            }

            if(flag){
                StringBuilder stringBuilder = new StringBuilder();
                for(int num : answer){
                    stringBuilder.append(num);
                }

                String result = stringBuilder.toString();

                if(max.equals("") || result.compareTo(max) > 0){
                    max = result;
                }

                if(min.equals("") || result.compareTo(min) < 0){
                    min = result;
                }

            }
            return;
        }

        for(int i=0; i<10; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = num[i];
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }
}
