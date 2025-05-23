package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스도쿠검증_D2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            int[][] map = new int[9][9];

            for(int i=0; i<9; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j=0; j<9; j++){
                    map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            boolean rowCheck = true;
            boolean colCheck = true;
            boolean celCheck = true;

            //가로 검사
            for(int i=0; i<9; i++){
                int[] num = new int[10];
                for(int j=0; j<9; j++){
                    num[map[i][j]]++;
                }

                for(int j=1; j<10; j++){
                    if(num[j] != 1){
                        rowCheck = false;
                    }
                }
            }

            //세로 검사
            for(int i=0; i<9; i++){
                int[] num = new int[10];
                for(int j=0; j<9; j++){
                    num[map[j][i]]++;
                }

                for(int j=1; j<10; j++){
                    if(num[j] != 1){
                        colCheck = false;
                    }
                }
            }

            // 3*3 검사
            for(int i=0; i<9; i+=3){
                for(int j=0; j<9; j+=3){
                    int[] num = new int[10];
                    for(int r=i; r<i+3; r++){
                        for(int c=j; c<j+3; c++){
                            num[map[r][c]]++;
                        }
                    }

                    for(int k=1; k<10; k++){
                        if(num[k] != 1){
                            celCheck = false;
                        }
                    }
                }
            }

            if(rowCheck && colCheck && celCheck){
                System.out.println("#" + test_case + " " + 1);
            }else{
                System.out.println("#" + test_case + " " + 0);
            }
        }
    }
}
