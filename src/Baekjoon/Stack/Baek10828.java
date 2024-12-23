package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int testCase = Integer.parseInt(bufferedReader.readLine());
        Deque<Integer> myStack = new ArrayDeque<>();

        for(int i=0; i<testCase; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();

            switch(command){
                case "push":
                    int temp = Integer.parseInt(stringTokenizer.nextToken());
                    myStack.push(temp);
                    break;
                case "top":
                    if(myStack.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(myStack.peek());
                    }
                    break;
                case "size":
                    System.out.println(myStack.size());
                    break;
                case "empty":
                    if(myStack.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "pop":
                    if(myStack.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(myStack.pop());
                    }
                    break;
            }
        }
    }
}
