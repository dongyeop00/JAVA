package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        br.close();

        int tmp = 1;
        int sum = 0;


        for(int i = 0; i < N.length(); i++){
            char C = N.charAt(i);

            if('0' <= C && C <= '9'){
                sum += (C - '0') * tmp;
            }else{
                sum += (C- 'A' + 10) * tmp;
            }
            tmp*= B;
        }

        System.out.println(sum);
    }
}