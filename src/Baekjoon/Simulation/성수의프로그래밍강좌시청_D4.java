package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 성수의프로그래밍강좌시청_D4 {
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            int[] array = new int[N];

            for(int i=0; i<N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(array);

            double avg = 0;
            for(int i=N-K; i<N; i++) {
                avg = (avg + array[i]) / 2.0;
            }

            System.out.println("#" + test_case + " " + avg);
        }
    }
}