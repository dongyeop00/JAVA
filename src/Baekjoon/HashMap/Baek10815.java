package Baekjoon.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek10815 {
    public static void main(String[] arg) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> map = new HashMap<>();
        int M = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0; i<M; i++){
            int temp = Integer.parseInt(st.nextToken());
            map.put(temp, map.getOrDefault(temp,0)+1);
        }

        System.out.println(map);


        int N = Integer.parseInt(bf.readLine());
        int[] result = new int[N];

        st = new StringTokenizer(bf.readLine());

        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());

            // key값 a의 value를 가져오는데 key값이 없으면 0을 가져온다.
            result[i] = map.getOrDefault(a,0);
        }

        for(int i : result){
            System.out.print(i + " ");
        }
    }
}
