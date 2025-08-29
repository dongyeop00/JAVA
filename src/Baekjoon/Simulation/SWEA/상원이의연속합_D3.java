package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 상원이의연속합_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case = 1; test_case<=T; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());
            int count = 0;

            for(int i=1; i<=N; i++){
                int sum = 0;
                for(int j=i; j<=N; j++){
                    sum += j;

                    if(sum == N){
                        count++;
                        break;
                    }else if(sum > N){
                        break;
                    }
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
