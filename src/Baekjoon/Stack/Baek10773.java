package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek10773 {
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        Deque<Integer> myDeque = new ArrayDeque<>();

        for(int i=0; i<testCase; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp != 0){
                myDeque.push(temp);
            }else{
                myDeque.pop();
            }
        }

        int sum = 0;

        while(!myDeque.isEmpty()){
            sum += myDeque.pop();
        }

        System.out.println(sum);
    }
}
