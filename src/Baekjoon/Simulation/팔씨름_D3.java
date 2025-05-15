package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팔씨름_D3 {
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for(int test_case = 1; test_case<=T; test_case++) {
            String str = bf.readLine();
            String result = "YES";
            int play = 15;

            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i) == 'x') {
                    play--;
                }
            }

            if(play < 8) {
                result = "NO";
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
