package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 1; test_case<=T; test_case++){
            int K = Integer.parseInt(bufferedReader.readLine());
            Stack<Integer> stack = new Stack<>();

            for(int i=0; i<K; i++){
                int temp = Integer.parseInt(bufferedReader.readLine());
                if(!stack.isEmpty()){
                    if(temp==0){
                        stack.pop();
                    }else{
                        stack.push(temp);
                    }
                }else{
                    if(temp!=0){
                        stack.push(temp);
                    }
                }
            }

            int sum = 0;
            int size = stack.size();
            for(int i=0; i<size; i++){
                sum += stack.pop();
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}
