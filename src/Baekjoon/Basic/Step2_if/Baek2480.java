package Baekjoon.Basic.Step2_if;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2480 {
    public static void main(String[] arg) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        if (a == b && b == c) {
            System.out.println(10000 + a * 1000);
        } else if (a == b || b == c || a == c) {
            int same = (a == b) ? a : (b == c) ? b : c;
            System.out.println(1000 + same * 100);
        } else {
            int max = Math.max(a, Math.max(b, c));
            System.out.println(max * 100);
        }
    }
}
