package Baekjoon.BitMasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(bf.readLine());
        int bitmask = 0;

        while(M --> 0){
            st = new StringTokenizer(bf.readLine());
            int x;
            String command = st.nextToken();

            switch (command){
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    bitmask |= 1 << (x-1);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    // xor을 쓸 수 없는 이유는 x가 없으면 추가되기 때문
                    bitmask &= ~(1 << (x-1));
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    int result = bitmask & (1 << (x-1));
                    if(result > 0){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    bitmask ^= 1 << (x-1);
                    break;
                case "all":
                    bitmask = (1 << 20) - 1;
                    break;
                case "empty":
                    bitmask = 20;
                    break;
            }
        }

        System.out.println(sb);
    }
}
