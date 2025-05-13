package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호짝짓기_D4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case=1; test_case<=10; test_case++){
            int T = Integer.parseInt(bufferedReader.readLine());
            String str = bufferedReader.readLine();
            Stack<Character> stack = new Stack<>();

            for(int i=0; i<T; i++){
                char temp = str.charAt(i);
                if(temp == '(' || temp == '<' || temp == '{' || temp == '['){
                    stack.push(temp);
                }else{
                    if(stack.isEmpty()){
                        stack.push(temp);
                    }else{
                        if(stack.peek() == '(' && temp == ')'){
                            stack.pop();
                        }else if(stack.peek() == '{' && temp == '}'){
                            stack.pop();
                        }else if(stack.peek() == '<' && temp == '>') {
                            stack.pop();
                        }else if(stack.peek() == '[' && temp == ']'){
                            stack.pop();
                        }else{
                            stack.push(temp);
                        }
                    }
                }
            }

            if(stack.isEmpty()){
                System.out.println("#" + test_case + " " + 1);
            }else{
                System.out.println("#" + test_case + " " + 0);
            }

        }
    }
}
