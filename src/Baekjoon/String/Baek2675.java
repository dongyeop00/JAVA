package Baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int testCase = Integer.parseInt(bufferedReader.readLine());

        while(testCase-- > 0){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int R = Integer.parseInt(stringTokenizer.nextToken());
            String S = stringTokenizer.nextToken();
            StringBuilder temp = new StringBuilder();

            for(int i=0; i<S.length(); i++){
                for(int j=0; j<R; j++){
                    temp.append(S.charAt(i));
                }
            }

            System.out.println(temp);
        }
    }
}
