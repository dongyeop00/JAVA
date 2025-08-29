package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 석찬이의받아쓰기_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case=1; test_case<=T; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());
            String answer = bufferedReader.readLine();
            String myAnswer = bufferedReader.readLine();
            int count = 0;

            for(int i=0; i<N; i++){
                if(answer.charAt(i) == myAnswer.charAt(i)){
                    count++;
                }
            }

            System.out.println("#"+test_case+" "+count);
        }
    }
}
