package Baekjoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        Deque<Integer> myQueue = new ArrayDeque<>();
        int testCase = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<testCase; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();

            switch(command){
                case "push":
                    int temp = Integer.parseInt(stringTokenizer.nextToken());
                    myQueue.offer(temp);
                    break;
                case "pop":
                    if(myQueue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(myQueue.poll());
                    }
                    break;
                case "size":
                    System.out.println(myQueue.size());
                    break;
                case "empty":
                    if(myQueue.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if(myQueue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(myQueue.peekFirst());
                    }
                    break;
                case "back":
                    if(myQueue.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(myQueue.peekLast());
                    }
                    break;
            }
        }
    }
}
