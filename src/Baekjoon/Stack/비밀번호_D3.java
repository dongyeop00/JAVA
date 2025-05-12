package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 비밀번호_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        for(int test_case = 1; test_case <= 10; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            String str = stringTokenizer.nextToken();

            Stack<Integer> stack = new Stack<>();

            for(int i=0; i<N; i++){
                int temp = str.charAt(i) - '0';

                if(stack.isEmpty()){
                    stack.push(temp);
                }else{
                    if(stack.peek() == temp){
                        stack.pop();
                    }else{
                        stack.push(temp);
                    }
                }
            }

            int[] result = new int[stack.size()];
            for(int i=stack.size()-1; i >= 0; i--){
                result[i] = stack.pop();
            }

            System.out.print("#" + test_case + " ");
            for(int i=0; i<result.length; i++){
                System.out.print(result[i]);
            }
            System.out.println();
        }
    }
}
