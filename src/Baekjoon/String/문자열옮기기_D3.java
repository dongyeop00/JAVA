package Baekjoon.String;

import java.util.Scanner;

public class 문자열옮기기_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 0; test_case <T; test_case++){
            String str = sc.next();
            int length = str.length();
            long num = 0;
            int K = sc.nextInt();

            for(int i=0; i<K; i++){
                num += sc.nextLong();
            }

            num %= length;

            if(num < 0){
                num += length;
            }

            String result = str.substring((int)num) + str.substring(0, (int)num);
            System.out.println(result);
        }
    }
}
