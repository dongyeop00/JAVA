package Baekjoon.달리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무선충전 {

    static int M, A, totalValue;
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    static int[] Asum, Bsum; // A와 B의 시간별 충전량
    static int[] Adir, Bdir; // A와 B의 시간별 이동 방향
    static BC[] bc; // BC들 저장
    static BC[] A_canCharge, B_canCharge; // A와 B가 충전할 수 있는 BC 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T= Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++){
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 이동 시간
            A = Integer.parseInt(st.nextToken()); // BC의 개수
            totalValue = 0;

            // 0초에도 충전할 수 있으므로 1 크게 입력받는다.
            Asum = new int[M+1];
            Bsum = new int[M+1];
            Adir = new int[M+1];
            Bdir = new int[M+1];

            bc = new BC[A];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=M; i++){
                Adir[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=M; i++){
                Bdir[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<A; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int range = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());

                bc[i] = new BC(y, x, range, power);
            }

            simulation();
            System.out.println("#" + testCase + " " + totalValue);
        }
    }

    private static void simulation(){
        int Ax = 1, Ay = 1;
        int Bx = 10, By = 10;

        for(int time=0; time<=M; time++){

            // 시간마다 이동
            Ax += dx[Adir[time]];
            Ay += dy[Adir[time]];
            Bx += dx[Bdir[time]];
            By += dy[Bdir[time]];

            // 현재 위치에서 충전할 수 있는 충전소 찾기
            A_canCharge = new BC[A];
            B_canCharge = new BC[A];
            int Aindex = 0; // 몇개 충전되어 있는지 count 해주는 pointer
            int Bindex = 0;

            // 현재 위치가 충전소 범위 안에 몇개 있는지 카운팅
            for(int i=0; i<A; i++){
                if(canChargeBC(Ax, Ay, bc[i])) A_canCharge[Aindex++] = bc[i];
                if(canChargeBC(Bx, By, bc[i])) B_canCharge[Bindex++] = bc[i];
            }

            // 충전하기
            int value = charge(Aindex, Bindex);
            totalValue += value;
        }
    }

    /***
     *
     * @param a : a가 충전할 수 있는 후보
     * @param b : b가 충전할 수 있는 후보
     * @return : 충전값
     */
    private static int charge(int a, int b){
        int value = 0;

        // 1. 현재 충전할 곳이 없다면
        if(a == 0 && b == 0){
            return 0;
        }

        // 2. a만 충전할 곳이 있다면
        if(a > 0 && b == 0){
            for(int i=0; i<a; i++){
                value = Math.max(value, A_canCharge[i].power);
            }
        }

        // 3. b만 충전할 곳이 있다면
        if(a == 0 && b > 0){
            for(int i=0; i<b; i++){
                value = Math.max(value, B_canCharge[i].power);
            }
        }

        // 4. a, b 둘다 충전할 곳이 있다면
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                int returnValue = 0;

                // 서로 같은 충전기를 선택할 때
                if(A_canCharge[i] == B_canCharge[j]){
                    returnValue = A_canCharge[i].power;
                }else{
                    returnValue = A_canCharge[i].power + B_canCharge[j].power;
                }

                value = Math.max(value, returnValue);
            }
        }

        return value;
    }

    private static boolean canChargeBC(int x, int y, BC bc){
        int dist = getDistance(x, y, bc.x, bc.y);

        if(dist <= bc.range){
            return true;
        }

        return false;
    }

    private static int getDistance(int x1, int y1, int x2, int y2){
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
    

    private static class BC{
        int x;
        int y;
        int range;
        int power;

        public BC(int x, int y, int range, int power) {
            this.x = x;
            this.y = y;
            this.range = range;
            this.power = power;
        }
    }
}
