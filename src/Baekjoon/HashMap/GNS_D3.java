package Baekjoon.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class GNS_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        String[] command = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case = 1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            String order = stringTokenizer.nextToken();
            int N = Integer.parseInt(stringTokenizer.nextToken());
            HashMap<String, Integer> map = new HashMap<>();

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<N; i++){
                String str = stringTokenizer.nextToken();
                map.put(str, map.getOrDefault(str, 0)+1);
            }

            for(int i=0; i<command.length; i++) {
                int count = map.get(command[i]);

                System.out.println("#" + test_case);
                for(int j=0; j<count; j++){
                    System.out.print(command[i] + " ");
                }
            }
        }
    }
}
