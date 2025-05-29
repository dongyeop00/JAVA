package Baekjoon.Graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek16953 {

    static long A, B;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        A = Long.parseLong(stringTokenizer.nextToken());
        B = Long.parseLong(stringTokenizer.nextToken());

        result = Integer.MAX_VALUE;
        DFS(A,0);

        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(result+1);
        }
    }

    private static void DFS(long current, int count){
        if(current > B){
            return;
        }

        if(current == B){
            result = Math.min(result, count);
            return;
        }

        DFS(current*2, count+1);
        DFS((current*10)+1, count+1);
    }
}
