package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다솔이의월급상자_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case=1; test_case<=T; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());

            double salary = 0;
            for(int i=0; i<N; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                double p = Double.parseDouble(stringTokenizer.nextToken());
                int x = Integer.parseInt(stringTokenizer.nextToken());

                salary += p * x;
            }

            System.out.println("#" + test_case + " " + salary);
        }
    }
}
