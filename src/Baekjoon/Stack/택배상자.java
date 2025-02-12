package Baekjoon.Stack;

import java.util.Stack;

public class 택배상자 {
    public static void main(String[] args) {
        int[] order = {4,3,1,2,5};
        solution(order);
    }

    private static void solution(int[] order){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=1; i<= order.length; i++){
            stack.push(i);

            while(!stack.isEmpty() && stack.peek() == order[answer]){
                stack.pop();
                answer++;
            }
        }

        System.out.println(answer);
    }
}
