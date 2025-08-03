package Baekjoon.Study;

import java.util.Arrays;

public class 조합_백트래킹 {

    static String[] arr = {"A", "B", "C", "D"};
    static String[] sel = new String[2];

    public static void main(String[] args) {
        Combination(0, 0);
    }

    private static void Combination(int depth, int index) {
        if(depth == sel.length){
            System.out.println(Arrays.toString(sel));
            return;
        }

        for(int i=index; i<arr.length; i++){
            sel[depth] = arr[i];
            Combination(depth+1, i+1);
        }
    }
}
