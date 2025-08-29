package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어디에단어가들어갈수있을까_D2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int K = Integer.parseInt(stringTokenizer.nextToken());

            int[][] map = new int[N][N];

            for(int i=0; i<N; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            int totalCount = 0;

            // 가로 검사
            for(int i=0; i<N; i++){
                int rowCount = 0;
                int colCount = 0;
                for(int j=0; j<N; j++){

                    //가로 검사
                    if(map[i][j] == 1){
                        rowCount++;
                    }

                    if(map[i][j] == 0){
                        if(rowCount == K){
                            totalCount++;
                        }
                        rowCount = 0;
                    }

                    //세로 검사
                    if(map[j][i] == 1){
                        colCount++;
                    }

                    if(map[j][i] == 0){
                        if(colCount == K){
                            totalCount++;
                        }
                        colCount = 0;
                    }
                }

                if(rowCount == K){
                    totalCount++;
                }

                if(colCount == K){
                    totalCount++;
                }
            }

            System.out.println("#" + test_case + " " + totalCount);
        }

    }
}
