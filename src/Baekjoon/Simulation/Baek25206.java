package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

/* 너의 평점은

(학점 x 과목 평점) / 학점의 총합

 */
public class Baek25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        double sum = 0;
        double scoreSum = 0;

        for(int i=0; i<20; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String name = stringTokenizer.nextToken();
            double score = Double.parseDouble(stringTokenizer.nextToken());
            String rank = stringTokenizer.nextToken();

            if(!rank.equals("P")){
                scoreSum += score;
            }

            switch(rank){
                case "A+":
                    sum += score * 4.5;
                    break;
                case "A0":
                    sum += score * 4.0;
                    break;
                case "B+":
                    sum += score * 3.5;
                    break;
                case "B0":
                    sum += score * 3.0;
                    break;
                case "C+":
                    sum += score * 2.5;
                    break;
                case "C0":
                    sum += score * 2.0;
                    break;
                case "D+":
                    sum += score * 1.5;
                    break;
                case "D0":
                    sum += score * 1.0;
                    break;
                case "F":
                    sum += score * 0;
            }
        }

        System.out.println(sum/scoreSum);
    }
}
