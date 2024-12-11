package Baekjoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1920 {
    public static void main(String[] arg) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] Narray = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0; i<N; i++){
            Narray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Narray);

        int M = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());

        for(int i=0; i<M; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(Arrays.binarySearch(Narray, temp) < 0){
                System.out.println(0);
            }else{
                System.out.println(1);
            }
        }
    }
}
