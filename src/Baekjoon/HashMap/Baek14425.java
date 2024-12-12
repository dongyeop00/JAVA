package Baekjoon.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek14425 {
    public static void main(String[] arg) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String str = bf.readLine();
            map.put(str,0);
        }

        for(int i=0; i<m; i++){
            String str = bf.readLine();
            if(map.containsKey(str)){
                count++;
            }
        }

        System.out.println(count);
    }
}
