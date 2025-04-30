package Baekjoon.HashMap;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 다양성측정_D3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int test_case=1; test_case<=T; test_case++){
            int num = scanner.nextInt();
            Set<Integer> set = new HashSet<>();
            while(num > 0){
                set.add(num%10);
                num /= 10;
            }
            System.out.println("#" + test_case + " " + set.size());
        }
    }
}
