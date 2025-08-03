package Baekjoon.Study;

import java.util.Arrays;

public class 순열_백트래킹 {

    static String[] arr = {"A", "B", "C", "D"};
    static boolean[] visited = new boolean[arr.length];
    static String[] sel = new String[2];

    public static void main(String[] args) {
        permutation(0);
    }

    public static void permutation(int depth){
        if(depth == sel.length){
            System.out.println(Arrays.toString(sel));
            return;
        }

        for(int i=0; i< arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                sel[depth] = arr[i];
                permutation(depth+1);
                visited[i] = false;
            }
        }
    }
}
