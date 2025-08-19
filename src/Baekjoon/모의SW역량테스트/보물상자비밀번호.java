package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 보물상자비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase<=TC; testCase++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Set<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            String str = br.readLine();
            int count = N / 4;

            for(int i=0; i<count; i++){
                String temp = str.substring(str.length()-1, str.length()) + str.substring(0, str.length()-1);
                str = temp;

                for(int j=0; j<temp.length(); j+=count){
                    String sub = temp.substring(j, j+count);
                    int num = Integer.parseInt(sub, 16);
                    set.add(num);
                }
            }

            for(int num : set){
                list.add(num);
            }

            Collections.sort(list, Collections.reverseOrder());
            System.out.println(list.get(K-1));
        }
    }
}
