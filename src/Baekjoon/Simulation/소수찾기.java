package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수찾기 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=0; i<N; i++){
            checkPrime(Integer.parseInt(stringTokenizer.nextToken()));
        }

        System.out.println(count);
    }

    private static void checkPrime(int temp){
        int checkCount = 0;

        for(int i=1; i<=temp; i++){
            if(temp % i == 0){
                checkCount++;
            }
        }

        if(checkCount == 2){
            count++;
        }
    }
}
