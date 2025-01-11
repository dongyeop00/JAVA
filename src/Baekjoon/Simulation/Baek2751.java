package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[] numArray = new int[n];

        for(int i=0; i<n; i++){
            numArray[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(numArray);

        for(int i=0; i<n; i++){
            System.out.println(numArray[i]);
        }

    }
}
