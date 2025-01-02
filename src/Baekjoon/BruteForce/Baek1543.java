package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String answer = bufferedReader.readLine();
        String temp = bufferedReader.readLine();
        int answerLen = answer.length();
        int tempLen = temp.length();

        answer = answer.replace(temp, "");

        System.out.println((answerLen - answer.length()) / tempLen);
    }
}
