package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 암호문2_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        for(int test_case=1; test_case<=10; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());
            List<Integer> list = new ArrayList<>();

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<N; i++){
                list.add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            int M = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<M; i++){
                String command = stringTokenizer.nextToken();

                if(command.equals("I")){
                    int index = Integer.parseInt(stringTokenizer.nextToken());
                    int count = Integer.parseInt(stringTokenizer.nextToken());
                    List<Integer> temp = new ArrayList<>();
                    for(int j=0; j<count; j++){
                        temp.add(Integer.parseInt(stringTokenizer.nextToken()));
                    }

                    list.addAll(index, temp);

                }else if(command.equals("D")){
                    int index = Integer.parseInt(stringTokenizer.nextToken());
                    int count = Integer.parseInt(stringTokenizer.nextToken());

                    for(int j=0; j<count && index < list.size(); j++){
                        list.remove(index);
                    }
                }
            }

            int count = 0;
            System.out.print("#" + test_case + " ");
            for(int num : list){
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
