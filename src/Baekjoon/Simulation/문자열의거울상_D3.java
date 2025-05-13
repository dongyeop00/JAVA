package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열의거울상_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            String str = bufferedReader.readLine();

            System.out.print("#" + test_case + " ");
            for(int i=str.length()-1; i >= 0; i--){
                if(str.charAt(i) == 'd'){
                    System.out.print("b");
                }else if(str.charAt(i) == 'b'){
                    System.out.print("d");
                }else if(str.charAt(i) == 'p'){
                    System.out.print("q");
                }else{
                    System.out.print("p");
                }
            }
            System.out.println();
        }
    }
}
