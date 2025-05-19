package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 문제제목붙이기_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case = 1; test_case<=T; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());
            Set<Character> set = new HashSet<>();

            for(int i=0; i<N; i++){
                String title = bufferedReader.readLine();
                set.add(title.charAt(0));
            }

            int count = 0;
            char start = 'A';

            System.out.println(set);

            while(set.contains(start)){
                start++;
                count++;
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
