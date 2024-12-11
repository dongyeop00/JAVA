package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek5585 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] change = {500,100,50,10,5,1};

        int money = 1000 - num;
        int count = 0;

        for(int i=0; i<change.length; i++){
            if(money / change[i] > 0){
                count += money / change[i];
                money %= change[i];
            }
        }

        System.out.println(count);
    }
}
