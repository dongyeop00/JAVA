package Baekjoon.BitMasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baek1497 {

    static int N, M;
    static long[] bitmask;
    static int maxSongs = 0;
    static int minGuitars = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        bitmask = new long[N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            String name = stringTokenizer.nextToken();
            String can = stringTokenizer.nextToken();
            long bit = 0;

            for (int j = 0; j < M; j++) {
                if (can.charAt(j) == 'Y') {
                    bit |= 1L << j;
                }
            }
            bitmask[i] = bit;
        }

//        for(int i=0; i< bitmask.length; i++) {
//            System.out.println(bitmask[i] + " -> " + String.format("%5s", Integer.toBinaryString(bitmask[i])).replace(' ', '0'));
//        }

        backTracking(0, 0, 0);
        System.out.println(maxSongs == 0 ? -1 : minGuitars);
    }

    public static void backTracking(int depth, long bit, int count) {
        // basis part
        // 더 이상 볼 기타가 없을 때까지 부분 집합 수행
        if(depth == N){
            int bitCount = Long.bitCount(bit);

            // 현재 연주할 수 있는 곡의 개수가 전에 계산했던 연주할 수 있는 최대 곡이 같다면?
            // 그 중 기타를 최소한으로 연주하는 걸로 변경
            if(bitCount == maxSongs){
                minGuitars = Math.min(minGuitars, count);
            }
            // 현재 연주할 수 있는 곡의 개수가 전에 계산했던 연주할 수 있는 최대 곡보다 크다면?
            // 최대 연주 곡과 최소 기타를 변경
            else if(bitCount > maxSongs){
                maxSongs = bitCount;
                minGuitars = count;
            }

            return;
        }

        // 현재 기타를 사용할 때
        backTracking(depth+1, bit | bitmask[depth], count+1);
        // 현재 기타를 사용하지 않을 때
        backTracking(depth+1, bit, count);
    }
}