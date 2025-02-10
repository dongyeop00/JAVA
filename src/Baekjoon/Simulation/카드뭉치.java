package Baekjoon.Simulation;

import java.util.Stack;

public class 카드뭉치 {
    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        //String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        solution(cards1, cards2, goal);
    }

    private static void solution(String[] cards1, String[] cards2, String[] goal){
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        for(int i = cards1.length-1; i>=0; i--){
            stack1.add(cards1[i]);
        }

        for(int i = cards2.length-1; i>=0; i--){
            stack2.add(cards2[i]);
        }

        for(String str : goal){
            if(!stack1.isEmpty() && str.equals(stack1.peek())){
                stack1.pop();
            }else if(!stack2.isEmpty() && str.equals(stack2.peek())){
                stack2.pop();
            }else{
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
        return;
    }
}
