package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek16198 {
    static List<Integer> map;
    static int N, max;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());
        max = Integer.MIN_VALUE;

        map = new ArrayList<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<N; i++){
            map.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        backTracking(0);
        System.out.println(max);
    }

    private static void backTracking(int sum){
        if(map.size() == 2){
            max = Math.max(max, sum);
            return;
        }

        for(int i=1; i<map.size()-1; i++){
            int temp = map.get(i);
            int value = map.get(i-1) * map.get(i+1);
            map.remove(i);
            backTracking(sum + value);
            map.add(i, temp);
        }

    }
}
