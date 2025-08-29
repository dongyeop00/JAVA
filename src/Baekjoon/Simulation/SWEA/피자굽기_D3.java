package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 피자굽기_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int[] cheeseArray = new int[M];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<M; i++){
                cheeseArray[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            Queue<Pizza> queue = new LinkedList<>();
            int PizzaIndex = N;
            Pizza last = null;
            for(int i=0; i<N; i++){
                queue.offer(new Pizza(i,cheeseArray[i]));
            }

            while(!queue.isEmpty()){
                Pizza current = queue.poll();
                current.cheese /= 2;

                if(current.cheese == 0){
                    if(PizzaIndex < M){
                        queue.offer(new Pizza(PizzaIndex, cheeseArray[PizzaIndex]));
                        PizzaIndex++;
                    }
                }else{
                    queue.offer(new Pizza(current.index, current.cheese));
                }

                if(queue.size() == 1 && PizzaIndex==M){
                    last = queue.peek();
                    break;
                }
            }

            System.out.println("#" + test_case + " " + (last.index+1));
        }
    }

    static class Pizza{
        int index;
        int cheese;

        Pizza(int index, int cheese){
            this.index = index;
            this.cheese = cheese;
        }
    }
}
