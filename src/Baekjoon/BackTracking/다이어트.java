package Baekjoon.BackTracking;

import java.util.*;
import java.io.*;

public class 다이어트 {

    static int N, minPrice;
    static int mp, mf, ms, mv;
    static Food[] foods;
    static String answer = "";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        foods = new Food[N];
        minPrice = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            foods[i] = new Food(p, f, s, v, price);
        }

        backTracking("", 0, 0, 0, 0, 0, 0);

        if(answer.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(minPrice);
            System.out.println(answer.trim());
        }
    }

    public static void backTracking(String str, int depth, int p, int f, int s, int v, int price){
        if(minPrice <= price){
            return;
        }

        if(mp <= p && mf <= f && ms <= s && mv <= v){
            minPrice = price;
            answer = str;
            return;
        }

        if(depth == N){
            return;
        }

        backTracking(str + " " + (depth+1),
                depth + 1,
                p + foods[depth].p,
                f + foods[depth].f,
                s + foods[depth].s,
                v + foods[depth].v,
                price + foods[depth].price);
        backTracking(str, depth+1, p, f, s, v, price);
    }


    public static class Food{
        int p;
        int f;
        int s;
        int v;
        int price;

        Food(int p, int f, int s, int v, int price){
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.price = price;
        }
    }

}
