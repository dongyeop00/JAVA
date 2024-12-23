package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] human = new int[N][2];

        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            human[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            human[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i=0; i<N; i++){
            int rank = 1;
            for(int j=0; j<N; j++){

                if(human[i][0] < human[j][0] && human[i][1] < human[j][1] ){
                    rank++;
                }
            }

            System.out.print(rank + " ");
        }

    }
}
