package Baekjoon.Simulation.SWEA;

import java.util.Scanner;

public class 일요일_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        String[] weeks = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        for(int test_case = 1; test_case<=T; test_case++){
            int sun = 6;
            int current = 0;
            int result = 0;
            String str = sc.next();

            for(int i=0; i<7; i++){
                if(str.equals(weeks[i])){
                    current = i;
                }
            }

            if(current == 6){
                result = 7;
            }else{
                result = sun - current;
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
