package Baekjoon.Simulation;

import java.util.Scanner;

public class 분수찾기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int count = 1;
        boolean end = false;

        for(int i=1; ; i++){
            if(i%2==0){ //짝수일 때 내려가는 방향, 분자 ↑, 분모 ↓
                for(int j=1; j<=i; j++){
                    if(count == N){
                        System.out.println(j + "/" + (i-j+1));
                        end = true;
                        break;
                    }
                    count++;
                }
            }else{ //홀수일 때 올라가는 방향, 분자 ↑, 분모 ↑
                for(int j=1; j<=i; j++){
                    if(count == N){
                        System.out.println((i-j+1) + "/" + j);
                        end = true;
                        break;
                    }
                    count++;
                }
            }
            if(end){
                break;
            }
        }
    }
}
