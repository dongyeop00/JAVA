package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문1_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case<11; test_case++){
            int length = Integer.parseInt(bufferedReader.readLine());
            int count = 0;
            boolean flag = true;
            char[][] map = new char[8][8];

            for(int i=0; i<8; i++){
                String str = bufferedReader.readLine();
                for(int j=0; j<8; j++){
                    map[i][j] = str.charAt(j);
                }
            }

            for(int i=0; i<8; i++){
                for(int j=0; j<8-length+1; j++){
                    flag = true;
                    for(int h=0; h<length/2; h++){
                        if(map[i][j+h] != map[i][j-h+length-1]) flag = false;
                    }
                    if(flag) count++;

                    flag = true;
                    for(int h=0; h<length/2; h++){
                        if(map[j+h][i] != map[j-h+length-1][i]) flag = false;
                    }
                    if(flag) count++;
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
