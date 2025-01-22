package Baekjoon.Graph.DFS;

public class 타겟넘버 {
    static int answer = 0;
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        dfs(numbers, target, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int[] numbers, int target, int current, int depth){
        if(depth == numbers.length){
            if(current == target){
                answer++;
            }
            return;
        }

        dfs(numbers, target, current + numbers[depth], depth+1);
        dfs(numbers, target, current - numbers[depth], depth+1);
    }
}