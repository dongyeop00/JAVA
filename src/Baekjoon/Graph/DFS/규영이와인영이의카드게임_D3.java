package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 규영이와인영이의카드게임_D3 {

    static int[] mapK;
    static int[] mapI;
    static int[] answer;
    static boolean[] used;
    static int win,draw,lose;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case = 1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            mapK = new int[9];
            mapI = new int[9];
            answer = new int[9];
            used = new boolean[19];
            win = 0;
            draw = 0;
            lose = 0;

            for(int i=0; i<9; i++){
                mapK[i] = Integer.parseInt(stringTokenizer.nextToken());
                used[mapK[i]] = true;
            }

            int index = 0;
            for(int i=1; i<19; i++){
                if(!used[i]){
                    mapI[index++] = i;
                }
            }

            DFS(0, new boolean[9]);
            System.out.println("#" + test_case + " " + win + " " + lose);
        }
    }

    private static void DFS(int depth, boolean[] visited){
        if(depth == 9){
            int Kscore = 0;
            int Iscore = 0;

            for(int i=0; i<9; i++){
                if(mapK[i] > answer[i]){
                    Kscore += mapK[i] + answer[i];
                }else{
                    Iscore += mapK[i] + answer[i];
                }
            }

            if(Kscore > Iscore){
                win++;
            }else if(Kscore < Iscore){
                lose++;
            }
            return;
        }

        for(int i=0; i<9; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = mapI[i];
                DFS(depth+1, visited);
                visited[i] = false;
            }
        }
    }
}
