package Baekjoon.Simulation;

import java.util.Scanner;

public class Calkin_Wilf_tree_1_D3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case=1; test_case<=T; test_case++ ){
            String str = sc.next();
            String[] command = str.split("");
            int child = 1;
            int parent = 1;

            for(int i=0; i<command.length; i++){
                String current = command[i];
                if(current.equals("L")){
                    parent += child;
                }else{
                    child += parent;
                }
            }

            System.out.println("#" + test_case + " " + child + " " + parent);
        }
    }
}
