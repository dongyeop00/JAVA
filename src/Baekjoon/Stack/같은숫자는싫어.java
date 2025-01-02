package Baekjoon.Stack;

import java.util.Stack;

public class 같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else{
                if(stack.peek() == arr[i]){
                    continue;
                }else{
                    stack.push(arr[i]);
                }
            }
        }
        System.out.println(stack);
    }
}
