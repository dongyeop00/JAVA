package Baekjoon.달리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 지도칠하기 {

    static int N, minChange;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++){
            N = Integer.parseInt(br.readLine());

            minChange = Integer.MAX_VALUE;
            map = new int[N][N];
            int[] color = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                color[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            backTracking(0, 0, color);
            System.out.println("#" + testCase + " " + minChange);
        }
    }

    public static void backTracking(int current, int changeCount, int[] color){

        if(changeCount >= minChange){
            return;
        }

        if(current == N){
            if(validation(color)){
                System.out.println(Arrays.toString(color));
                minChange = Math.min(minChange, changeCount);
            }
            return;
        }

        for(int next=0; next<N; next++){
            if(map[current][next] != 0 && color[current] == color[next]){
                int temp = color[current];
                for(int i=1; i<=4; i++){
                    if(color[current] == i) continue;
                    color[current] = i;
                    backTracking(current+1, changeCount+1, color);
                    color[current] = temp;
                }
            }
            backTracking(current+1, changeCount, color);
        }
    }

    public static boolean validation(int[] color){
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(map[i][j] == 1 && color[i] == color[j]){
                    return false;
                }
            }
        }
        return true;
    }
}
