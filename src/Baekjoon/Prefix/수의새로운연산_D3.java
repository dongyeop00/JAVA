package Baekjoon.Prefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수의새로운연산_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int[][] map = new int[300][300];
        int start = 0;
        int raise = 0;

        for(int i=1; i<300; i++){
            start += i;
            raise = i;
            for(int j=1; j<300; j++){
                if(j==1){
                    map[i][j] = start;
                }else{
                    map[i][j] = map[i][j-1] + raise++;
                }
            }
        }

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int p = Integer.parseInt(stringTokenizer.nextToken());
            int q = Integer.parseInt(stringTokenizer.nextToken());

            int pX = 0, pY = 0, qX = 0, qY = 0;
            for(int i=1; i<300; i++){
                for(int j=1; j<300; j++){
                    if(map[i][j] == p){
                        pX = i;
                        pY = j;
                    }

                    if(map[i][j] == q){
                        qX = i;
                        qY = j;
                    }
                }
            }

            int newX = pX + qX;
            int newY = pY + qY;

            System.out.println("#" + test_case + " " + map[newX][newY]);
        }
    }
}
