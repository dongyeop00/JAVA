package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 늘어지는소리만들기_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            String str = bufferedReader.readLine();
            int H = Integer.parseInt(bufferedReader.readLine());
            List<Character> list = new ArrayList<>();

            for(int i=0; i<str.length(); i++){
                list.add(str.charAt(i));
            }

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int[] location = new int[H];
            for(int i=0; i<H; i++){
                location[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            Arrays.sort(location);

            for(int i=H-1; i>=0; i--){
                list.add(location[i], '-');
            }

            System.out.print("#" + test_case + " ");
            for(char ch : list){
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
