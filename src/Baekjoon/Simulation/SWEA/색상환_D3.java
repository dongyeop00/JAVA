package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색상환_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        String[] color = {"red", "orange", "yellow", "green", "blue", "purple"};
        int size = color.length;

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str1 = stringTokenizer.nextToken();
            int str1Index = 0, str2Index = 0;
            String str2 = stringTokenizer.nextToken();

            for (int i = 0; i < size; i++) {
                if (str1.equals(color[i])) {
                    str1Index = i;
                }

                if (str2.equals(color[i])) {
                    if (str2.equals(color[i])) {
                        str2Index = i;
                    }
                }
            }

            if(str1Index == str2Index){
                System.out.println("E");
            }else if((str1Index+1) % size == str2Index || (str1Index-1+size) % size == str2Index){
                System.out.println("A");
            }else if((str2Index+3) % size == str2Index || (str1Index-3+size) % size == str2Index){
                System.out.println("C");
            }else{
                System.out.println("X");
            }
        }
    }
}
