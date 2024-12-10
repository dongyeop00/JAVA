package Baekjoon.Basic.Step2_if;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2884 {
    public static void main(String[] arg) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int hour = Integer.parseInt(stringTokenizer.nextToken());
        int min = Integer.parseInt(stringTokenizer.nextToken());

        min -= 45;

        if(min<0){
            if(hour==0){
                hour = 23;
                min+=60;
            }else{
                hour--;
                min+=60;
            }
        }

        System.out.println(hour + " " + min);
    }
}
