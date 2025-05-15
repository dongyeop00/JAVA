package Baekjoon.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 반반_D3 {
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 1; test_case<=T; test_case++) {
            String str = bufferedReader.readLine();
            HashMap<Character, Integer> map = new HashMap<>();
            int count = 0;
            boolean check = true;

            for(int i=0; i<str.length(); i++) {
                char temp = str.charAt(i);
                map.put(temp, map.getOrDefault(temp, 0)+1);
            }

            count = map.size();

            for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                if(entry.getValue() != 2) {
                    check = false;
                }
            }

            if(count == 2 && check){
                System.out.println("#" + test_case + " " + "Yes");
            }else {
                System.out.println("#" + test_case + " " + "No");
            }
        }
    }
}
