package Baekjoon.달리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 준환이의양팔저울 {

    static int N, count;
    static int[] weight;
    static int[] select;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++){
            N = Integer.parseInt(br.readLine());

            count = 0;
            weight = new int[N];
            select = new int[N];
            visited = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                weight[i] = Integer.parseInt(st.nextToken());
            }

            solve(0);
            System.out.println("#" + testCase + " " + count);
        }
    }

    // 모든 순열 N! 을 만들었음
    public static void solve(int depth){
        if(depth == N){
            isValid(0, 0, 0);
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                select[depth] = weight[i];
                solve(depth+1);
                visited[i] = false;
            }
        }
    }

    // 2^N 수행
    public static void isValid(int index, int left, int right){
        if(index == N){
            count++;
            return;
        }

        if(right + select[index] <= left){
            right += select[index];
            isValid(index+1, left, right);
            right -= select[index];
        }

        left += select[index];
        isValid(index+1, left, right);
        left -= select[index];
    }

}
