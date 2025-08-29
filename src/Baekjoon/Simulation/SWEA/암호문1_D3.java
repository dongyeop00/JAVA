package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 암호문1_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        for(int test_case=1; test_case<=10; test_case++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            List<Integer> array = new ArrayList<>();

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<N; i++){
                array.add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            int C = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for(int i=0; i<C; i++){
                String command = stringTokenizer.nextToken();
                int index = Integer.parseInt(stringTokenizer.nextToken());
                int num = Integer.parseInt(stringTokenizer.nextToken());
                List<Integer> temp = new ArrayList<>();

                for(int j=0; j<num; j++){
                    temp.add(Integer.parseInt(stringTokenizer.nextToken()));
                }

                array.addAll(index, temp);
            }

            int count = 0;
            System.out.print("#" + test_case + " ");
            for(int num : array){
                if(count < 10){
                    System.out.print(num + " ");
                    count++;
                }else{
                    break;
                }
            }
            System.out.println();
        }
    }
}
