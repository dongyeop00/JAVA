package Baekjoon.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 정수의교집합_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case = 1; test_case<=T; test_case++){
            HashMap<Integer, Integer> map = new HashMap<>();

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<a; i++){
                int temp = Integer.parseInt(stringTokenizer.nextToken());
                map.put(temp, map.getOrDefault(temp,0)+1);
            }

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int count = 0;
            for(int i=0; i<b; i++){
                int temp = Integer.parseInt(stringTokenizer.nextToken());
                if(map.containsKey(temp)) count++;
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
