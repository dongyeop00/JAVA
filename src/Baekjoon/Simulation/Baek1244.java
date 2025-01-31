package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1244 {

    static int num;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        num = Integer.parseInt(bufferedReader.readLine());
        arr = new int[num+1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=1; i<=num; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int studentCount = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<studentCount; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int sex = Integer.parseInt(stringTokenizer.nextToken());
            int number = Integer.parseInt(stringTokenizer.nextToken());

            if(sex == 1){
                maleSolution(number);
            }else{
                femaleSolution(number);
            }
        }

        for(int i=1; i<=num; i++){
            System.out.print(arr[i] + " ");
            if(i % 20 == 0){
                System.out.println();
            }
        }
    }

    private static void maleSolution(int number){
        for (int i = number; i <= num; i += number) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }

    private static void femaleSolution(int number){
        arr[number] = arr[number] == 0 ? 1 : 0;

        int left = number -1;
        int right = number + 1;

        while(left >= 1 && right <= num){
            if(arr[left] != arr[right]){
                break;
            }

            arr[left] = arr[left] == 0 ? 1 : 0;
            arr[right] = arr[right] == 0 ? 1 : 0;

            left--;
            right++;
        }

    }
}
