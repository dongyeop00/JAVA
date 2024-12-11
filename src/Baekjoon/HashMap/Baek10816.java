package Baekjoon.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek10816 {
    public static void main(String[] arg) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(bf.readLine());
        HashMap<Integer, Integer> myMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0; i<M; i++){
            int temp = Integer.parseInt(st.nextToken());
            myMap.put(temp, myMap.getOrDefault(temp, 0) + 1);
        }

        int N = Integer.parseInt(bf.readLine());
        int[] result = new int[N];

        st = new StringTokenizer(bf.readLine());

        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(st.nextToken());
            result[i] = myMap.getOrDefault(temp,0);
        }

        for(int count : result){
            System.out.print(count + " ");
        }
    }
}
