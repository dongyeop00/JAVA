package Baekjoon.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 새샘이의735게임_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int[] array = new int[7];
            Set<Integer> set = new HashSet<>();

            for(int i=0; i<array.length; i++){
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            for(int i=0; i<array.length-2; i++){
                for(int j=i+1; j<array.length-1; j++){
                    for(int k=j+1; k< array.length; k++){
                        int sum = array[i] + array[j] + array[k];
                        set.add(sum);
                    }
                }
            }

            int[] result = new int[set.size()];
            int index = 0;
            for(int num : set){
                result[index++] = num;
            }

            Arrays.sort(result);

            System.out.println("#" + test_case + " " + result[set.size()-5]);
        }
    }
}
