package Baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모음이보이진않는사람_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = {"a", "e", "i", "o", "u"};

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case=1; test_case<=T; test_case++){
            String str = bufferedReader.readLine();

            for(int i=0; i< array.length; i++){
                str = str.replace(array[i], "");
            }

            System.out.println("#"+test_case+" "+str);
        }
    }
}
