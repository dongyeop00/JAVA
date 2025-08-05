package Baekjoon.BitMasking;

import java.io.*;

public class Baek9997 {

    static int[] bitmask;
    static int N, count;

    public static void main(String[] args) throws Exception, IOException {
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        count = 0;
        bitmask = new int[N];

        for(int i=0; i<N; i++) {
            String str = bf.readLine();
            int bit = 0;

            for(char c : str.toCharArray()) {
                bit |= 1 << (c - 'a');
            }

            bitmask[i] = bit;
        }

        subset(0,0);
        System.out.println(count);
    }

    public static void subset(int index, int bit) {
        if(index == N) {
            if(bit == (1<< 26) -1) {
                count++;
            }
            return;
        }

        subset(index+1, bit | bitmask[index]);
        subset(index+1, bit);
    }

}

