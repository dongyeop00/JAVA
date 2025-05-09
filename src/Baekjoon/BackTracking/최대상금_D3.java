package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 최대상금_D3 {

    static int[] array;
    static int change, size, max;
    static Set<String>[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = stringTokenizer.nextToken();
            change = Integer.parseInt(stringTokenizer.nextToken());

            array = new int[str.length()];
            size = str.length();
            max = 0;
            visited = new HashSet[11];
            for(int i=0; i<11; i++){
                visited[i] = new HashSet<>();
            }

            for(int i=0; i<str.length(); i++){
                array[i] = str.charAt(i) - '0';
            }

            backTracking(0);
            System.out.println("#" + test_case + " " + max);
        }
    }

    public static void backTracking(int depth){

        String current = Arrays.toString(array);
        if(visited[depth].contains(current)){
            return;
        }else{
            visited[depth].add(current);
        }

        if(depth == change){
            int sum = 0;
            for(int i=0; i<size; i++){
                sum = sum * 10 + array[i];
            }

            max = Math.max(sum, max);
            return;
        }

        for(int i=0; i<size-1; i++){
            for(int j=i+1; j<size; j++){
                swap(i, j);
                backTracking(depth+1);
                swap(i, j);
            }
        }
    }

    public static void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
