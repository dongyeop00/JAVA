package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {
    public static void main(String[] arg) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sugar = Integer.parseInt(bufferedReader.readLine());
        int count = 0;

        while(sugar > 0){
            if(sugar % 5 == 0){
                count += sugar/5;
                break;
            }else{
                sugar -= 3;
                count++;
            }
            if(sugar < 0){
                count = -1;
            }
        }
        System.out.println(count);
    }
}
