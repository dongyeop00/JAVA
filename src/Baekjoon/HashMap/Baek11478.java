package Baekjoon.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Baek11478 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Set<String> subString = new HashSet<>();

        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++ ){
                subString.add(str.substring(i,j));
            }
        }

        System.out.println(subString.size());
    }
}
