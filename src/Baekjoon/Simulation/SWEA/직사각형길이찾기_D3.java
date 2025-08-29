package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 직사각형길이찾기_D3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 1; test_case<= T; test_case++){
            HashMap<Integer, Integer> map = new HashMap<>();

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<3; i++){
                int temp = Integer.parseInt(stringTokenizer.nextToken());

                map.put(temp, map.getOrDefault(temp,0)+1);
            }

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue()==1){
                    System.out.println("#" + test_case + " " + entry.getKey());
                    break;
                }else if(entry.getValue()==3){
                    System.out.println("#" + test_case + " " + entry.getKey());
                    break;
                }
            }
        }
    }
}
