package Baekjoon.Basic.Step2_if;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2525 {
    public static void main(String[] arg) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int hour = Integer.parseInt(stringTokenizer.nextToken());
        int min = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int num = Integer.parseInt(stringTokenizer.nextToken());

        int plusHour = num/60;
        int plusMin = num%60;

        hour += plusHour;
        min += plusMin;

        if(hour>23){
            hour -= 24;
            if(min>=60){
                min -= 60;
                hour++;
            }
        }else {
            if(min>=60){
                min -= 60;
                hour++;
                if(hour>23){
                    hour -= 24;
                }
            }
        }

        System.out.println(hour + " " + min);
    }
}
