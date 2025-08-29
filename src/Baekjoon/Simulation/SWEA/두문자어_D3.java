package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 두문자어_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 1; test_case<=T; test_case++){
            String str = bufferedReader.readLine();
            str = str.toUpperCase();

            String[] strArray = str.split(" ");
            char[] charArray = new char[strArray.length];

            for(int i=0; i<strArray.length; i++){
                charArray[i] = strArray[i].charAt(0);
            }

            System.out.print("#" + test_case + " ");
            for(int i=0; i< strArray.length; i++){
                System.out.print(charArray[i]);
            }
            System.out.println();
        }
    }
}
