package Baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++){
            int T = Integer.parseInt(bufferedReader.readLine());

            String answer = bufferedReader.readLine();
            String str = bufferedReader.readLine();

            String replace = str.replace(answer, "");
            int result = (str.length() - replace.length()) / answer.length();
            System.out.println("#" + T + " " + result);
        }
    }
}
