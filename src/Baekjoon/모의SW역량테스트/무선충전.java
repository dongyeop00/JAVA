package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무선충전 {

    static int M, A, totalValue;
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    static int[] Asum, Bsum;
    static int[] Adir, Bdir;
    static AP[] ap;
    static AP[] Acharge, Bcharge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            Asum = new int[M+1];
            Bsum = new int[M+1];
            Adir = new int[M+1];
            Bdir = new int[M+1];
            ap = new AP[A];
            Acharge = new AP[A];
            Bcharge = new AP[A];
            totalValue = 0;

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=M; i++) Adir[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=M; i++) Bdir[i] = Integer.parseInt(st.nextToken());

            for(int i=0; i<A; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int range = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());
                ap[i] = new AP(x, y, range, power);
            }

            int aX = 1, aY = 1;
            int bX = 10, bY = 10;

            // 0초 ~ M초까지 이동
            for(int i=0; i<=M; i++){

                aX += dx[Adir[i]];
                aY += dy[Adir[i]];
                bX += dx[Bdir[i]];
                bY += dy[Bdir[i]];

                Acharge = new AP[A];
                Bcharge = new AP[A];
                int AchargeIndex = 0;
                int BchargeIndex = 0;

                // 충전 가능한 리스트 뽑기
                for(int j=0; j<A; j++){
                    if(check(aX, aY, j)) Acharge[AchargeIndex++] = ap[j];
                    if(check(bX, bY, j)) Bcharge[BchargeIndex++] = ap[j];
                }

                // 충전하기
                int num = calcChargeValue(AchargeIndex, BchargeIndex);
                System.out.println(num);
                totalValue += num;
            }

            System.out.println("#" + testCase + " " + totalValue);
        }
    }

    public static int calcChargeValue(int a, int b){
        int value = 0;

        // 충전할 곳이 없는 경우
        if(a == 0 && b == 0){
            value = 0;
        }

        // 충전할 곳이 A밖에 없는 경우
        if(a > 0 && b == 0){
            for(int i=0; i<a; i++){
                value = Math.max(value, Acharge[i].power);
            }
        }

        // 충전할 곳이 B밖에 없는 경우
        if(a == 0 && b > 0){
            for(int i=0; i<b; i++){
                value = Math.max(value, Bcharge[i].power);
            }
        }

        // 충전할 곳이 두군데 있는 경우
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                int sum;

                //같은 ap 선택
                if(Acharge[i] == Bcharge[j]){
                    sum = Acharge[i].power;
                }else{
                    sum = Acharge[i].power + Bcharge[j].power;
                }
                value = Math.max(value, sum);
            }
        }

        return value;
    }

    public static boolean check(int x, int y, int index){
        if(ap[index].range >= calc(ap[index], x, y)){
            return true;
        }
        return false;
    }

    public static int calc(AP ap, int x, int y){
        return Math.abs(ap.x - x) + Math.abs(ap.y - y);
    }

    public static class AP{
        int x;
        int y;
        int range;
        int power;

        AP(int x, int y, int range, int power){
            this.x = x;
            this.y = y;
            this.range = range;
            this.power = power;
        }
    }
}
