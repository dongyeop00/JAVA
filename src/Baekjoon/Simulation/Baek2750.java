package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[] numArray = new int[n];

        for(int i=0; i<n; i++){
            numArray[i] = Integer.parseInt(bufferedReader.readLine());
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                if(numArray[j] > numArray[j+1]){
                    int temp = numArray[j];
                    numArray[j] = numArray[j+1];
                    numArray[j+1] = temp;
                }
            }
        }

        for(int i=0; i<n; i++){
            System.out.println(numArray[i]);
        }
    }
}
