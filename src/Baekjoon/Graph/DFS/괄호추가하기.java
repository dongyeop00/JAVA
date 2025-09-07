package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 괄호추가하기 {
    static int N, max;
    static String[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        str = br.readLine().split("");

        dfs(0, Integer.parseInt(str[0]));
        System.out.println(max);
    }

    public static void dfs(int index, int sum){
        // basis part
        if(index >= str.length-1){
            max = Math.max(max, sum);
            return;
        }

        // inductive part

        // 1. 괄호 없이 다음 숫자를 바로 적용
        int next = Integer.parseInt(str[index+2]);
        int result = calc(sum, str[index+1], next);
        dfs(index+2, result);

        // 2. 괄호를 쳐서 "다음 연산"을 먼저 계산
        //    즉, [다음숫자, operator, 그다음숫자]를 먼저 계산한 뒤,
        //    그 결과를 현재 연사자로 sum에 적용한다.
        if(index+4 < N){
            int temp = calc(
                    Integer.parseInt(str[index+2]),
                    str[index+3],
                    Integer.parseInt(str[index+4]));

            // 이제 현재 연산자(str[index+1])로 sum과 temp를 결합
            int result2 = calc(sum, str[index+1], temp);
            dfs(index+4, result2);
        }
    }

    public static int calc(int a, String operator, int b) {
        if(operator.equals("+")) {
            return a+b;
        }else if(operator.equals("-")) {
            return a-b;
        }else {
            return a*b; // operator.equals("*")
        }
    }
}
