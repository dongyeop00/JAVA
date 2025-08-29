package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영준이와신비한뿔의숲_D3 {
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        for(int test_case=1; test_case <= T; test_case++) {
            st = new StringTokenizer(bf.readLine());

            int N = Integer.parseInt(st.nextToken()); //뿔
            int M = Integer.parseInt(st.nextToken()); //짐승

            int twin = N - M;
            int uniq = 2*M - N;

            System.out.println("#" + test_case + " " + uniq + " " + twin);
        }
    }

}