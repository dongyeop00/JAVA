package Baekjoon.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1764 {
    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> human = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(int i = 0; i<N; i++){
            String name = br.readLine();
            human.put(name, 1);
        }

        for(int i=0; i<M; i++){
            String name = br.readLine();
            human.put(name, human.getOrDefault(name, 0)+1);
        }

        for(Map.Entry<String, Integer> entry : human.entrySet()){
            if(entry.getValue() == 2){
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);

        System.out.println(result.size());

        for(String str : result){
            System.out.println(str);
        }

    }
}
