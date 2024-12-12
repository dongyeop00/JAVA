package Baekjoon.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek7785 {
    public static void main(String[] arg) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(bf.readLine());
        HashMap<String, String> map = new HashMap<>();

        for(int i=0; i<testCase; i++){
            st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if(status.equals("enter")){
                map.put(name,status);
            }else if(status.equals("leave")){
                map.remove(name);
            }
        }

        List<String> name = new ArrayList<>(map.keySet());

        name.sort(Collections.reverseOrder());

        for(String list : name){
            System.out.println(list);
        }

    }
}
