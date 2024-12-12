package Baekjoon.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek1620 {
    public static void main(String[] arg) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameMap = new HashMap<>();
        HashMap<Integer, String> intMap = new HashMap<>();

        for(int i=1; i<=N; i++){
            String name = bf.readLine();
            nameMap.put(name,i);
            intMap.put(i,name);
        }

        for(int i=0; i<M; i++){
            String name = bf.readLine();

            if(isNumberic(name)){
                int num = Integer.parseInt(name);
                System.out.println(intMap.get(num));
            }else{
                System.out.println(nameMap.get(name));
            }
        }
    }

    private static boolean isNumberic(String name){
        char c = name.charAt(0);

        if('0' <= c && c<= '9' ){
            return true;
        }else{
            return false;
        }
    }
}
