package Baekjoon.Basic.Step2_if;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9498 {
    public static void main(String[] arg) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if(90<=num && num<=100){
            System.out.println("A");
        }else if(80<=num && num<90){
            System.out.println("B");
        }else if(70<=num && num<80){
            System.out.println("C");
        }else if(60<=num && num<70){
            System.out.println("D");
        }else{
            System.out.println("F");
        }

    }
}
