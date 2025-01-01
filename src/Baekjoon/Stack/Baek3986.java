package Baekjoon.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Baek3986 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        int count = 0;

        for(int i=0; i<testCase; i++){
            String str = scanner.next();
            Deque<Character> deque = new ArrayDeque<>();

            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);

                if(deque.isEmpty()){
                    deque.push(c);
                }else{
                    if(deque.peek() == c){
                        deque.pop();
                    }else{
                        deque.push(c);
                    }
                }

            }
            if(deque.isEmpty()){
                 count++;
            }
        }
        System.out.println(count);
    }
}
