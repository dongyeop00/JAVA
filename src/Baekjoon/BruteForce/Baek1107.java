package Baekjoon.BruteForce;

import java.util.*;
import java.io.*;

public class Baek1107 {

    public static void main(String[] args) throws Exception, IOException {
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        boolean[] broken = new boolean[10];

        if(M > 0) {
            st = new StringTokenizer(bf.readLine());
            for(int i=0; i<M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        if(N == 100) {
            System.out.println(0);
            return;
        }



        int result = Math.abs(N - 100);

        for(int i=0; i<999999; i++) {
            String num = String.valueOf(i);
            boolean check = false;

            for(int j=0; j<num.length(); j++) {
                if(broken[num.charAt(j) - '0']) {
                    check = true;
                    break;
                }
            }

            if(!check) {
                int min = Math.abs(N-i) + num.length();
                result = Math.min(result, min);
            }
        }

        System.out.println(result);
    }

}

