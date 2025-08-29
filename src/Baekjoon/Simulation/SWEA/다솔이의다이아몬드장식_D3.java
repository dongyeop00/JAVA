package Baekjoon.Simulation.SWEA;

import java.util.Scanner;

public class 다솔이의다이아몬드장식_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case=0; test_case<T; test_case++){
            String str = sc.next();

            System.out.print("..#.");
            for(int i=0; i<str.length()-1; i++){
                System.out.print("..#.");
            }
            System.out.println(".");

            for(int i=0; i<str.length(); i++){
                System.out.print(".#.#");
            }
            System.out.println(".");

            for(int i=0; i<str.length(); i++){
                System.out.print("#." + str.charAt(i) + ".");
            }
            System.out.println("#");

            for(int i=0; i<str.length(); i++){
                System.out.print(".#.#");
            }
            System.out.println(".");

            System.out.print("..#.");
            for(int i=0; i<str.length()-1; i++){
                System.out.print("..#.");
            }
            System.out.println(".");
        }
    }
}
