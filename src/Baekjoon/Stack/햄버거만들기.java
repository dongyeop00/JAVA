package Baekjoon.Stack;

import java.util.Stack;

public class 햄버거만들기 {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        solution(ingredient);
    }

    private static void solution(int[] ingredient){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i< ingredient.length; i++){
            stack.push(ingredient[i]);

            if(stack.size() >= 4){
                int length = stack.size();

                if(stack.get(length-4) == 1
                && stack.get(length-3) == 2
                && stack.get(length-2) == 3
                && stack.get(length-1) == 1){
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }

        System.out.println(answer);
    }
}
