package Baekjoon.Basic.Step2_if;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2753 {
    public static void main(String[] arg) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if(num%4==0 && num%100!=0){
            System.out.println("1");
        }else if(num%100==0 && num%400!=0){
            System.out.println("0");
        }else if(num%400==0){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
}
