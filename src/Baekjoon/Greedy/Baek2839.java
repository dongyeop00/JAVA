package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2839 {
    public static void main(String[] arg) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sugar = Integer.parseInt(bufferedReader.readLine());
        int count = 0;

        while(sugar > 1){
            if(sugar % 5 == 0){
                count += sugar/5;
                System.out.println(count);
                break;
            }
            sugar -= 3;
            count++;
        }
    }
}
