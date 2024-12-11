package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek9012 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            String str = br.readLine();
            Deque<Character> myDeque = new ArrayDeque<>();
            for(int k=0; k<str.length(); k++){
                char c = str.charAt(k);
                if(c == '('){
                    myDeque.push(c);
                }else{ // )
                    if(myDeque.isEmpty()){
                        myDeque.push(c);
                    }else if(myDeque.peek() == '('){
                        myDeque.pop();
                    }
                }
            }
            if(myDeque.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
