package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두가지빵의딜레마_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case = 1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());
            int C = Integer.parseInt(stringTokenizer.nextToken());

            int min = Math.min(A,B);

            int count = 0;

            count += C / min;

            C -= count*min;

            count += C / B;

            System.out.println("#" + test_case + " " + count);
        }
    }
}
