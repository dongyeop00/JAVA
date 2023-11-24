package main.Solved;

import java.util.Scanner;

public class No2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[9];

        for(int i=0; i<num.length; i++){
            num[i] = sc.nextInt();
        }

        int max = 0;
        int line = 0;

        for(int i=0; i<num.length; i++){
            if(max<num[i]){
                max=num[i];
                line = i+1;
            }
        }

        System.out.println(max);
        System.out.println(line);
    }
}
