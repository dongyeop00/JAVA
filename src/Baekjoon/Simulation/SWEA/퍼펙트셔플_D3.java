package Baekjoon.Simulation.SWEA;

import java.util.*;
import java.io.*;

public class 퍼펙트셔플_D3 {
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());

        for(int test_case = 1; test_case<= T; test_case++) {
            int N = Integer.parseInt(bf.readLine());
            String[] str = new String[N];

            st = new StringTokenizer(bf.readLine());
            for(int i=0; i<N; i++) {
                str[i] = st.nextToken();
            }

            System.out.print("#" + test_case + " ");
            int front = 0;
            int back = 0;
            if(N % 2 == 0) {
                back = N/2;
                while(back < N) {
                    System.out.print(str[front++] + " " + str[back++] + " ");
                }
            }else {
                back = N/2+1;
                while(back < N) {
                    System.out.print(str[front++] + " " + str[back++] + " ");
                }
                System.out.print(str[front]);
            }
            System.out.println();
        }
    }

}

