package Baekjoon.Study;

public class 부분집합_재귀 {

    static String[] arr = {"A", "B", "C"};
    static boolean[] included = new boolean[arr.length];

    public static void main(String[] args) {
        Subset(0);
    }

    public static void Subset(int depth){
        if(depth == arr.length){
            for(int i = 0; i<arr.length; i++){
                if(included[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        // 현재 원소 포함
        included[depth] = true;
        Subset(depth+1);


        // 현재 원소 미포함
        included[depth] = false;
        Subset(depth+1);
    }
}
