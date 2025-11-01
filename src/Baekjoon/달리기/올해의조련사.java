package Baekjoon.달리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 올해의조련사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int testCase=1; testCase<=T; testCase++){
            int N = Integer.parseInt(br.readLine());

            char[] origin = new char[N];

            for(int i=0; i<N; i++){
                String str = br.readLine();
                origin[i] = str.charAt(0);
            }

            String result = getString(N, origin);
            System.out.println("#" + testCase + " " + result);
        }
    }

    public static String getString(int N, char[] origin){
        StringBuilder sb = new StringBuilder();

        int left = 0;
        int right = N-1;

        while(left <= right){
            if(origin[left] < origin[right]){
                sb.append(origin[left++]);
            }else if(origin[left] > origin[right]){
                sb.append(origin[right--]);
            }else{
                // 양 끝이 같으면 안쪽에서 검사해야됨
                int newLeft = left + 1;
                int newRight = right - 1;
                boolean where = true;

                while(newLeft <= newRight){
                    if(origin[newLeft] < origin[newRight]){
                        where = true;
                        break;
                    } else if(origin[newLeft] > origin[newRight]){
                        where = false;
                        break;
                    }

                    newLeft++;
                    newRight--;
                }


                if(where){
                    sb.append(origin[left++]);
                }else{
                    sb.append(origin[right--]);
                }
            }
        }

        return sb.toString();
    }

}
