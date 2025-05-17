package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기자르기_D4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            String str = bufferedReader.readLine();
            Stack<Character> stack = new Stack<>();
            int count = 0;

            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '('){
                    stack.push(str.charAt(i));
                } else{ // )
                    stack.pop();
                    if(str.charAt(i-1) == '('){
                        count += stack.size();
                    }else{ // )
                        count += 1;
                    }
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
