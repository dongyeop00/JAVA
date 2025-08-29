package Baekjoon.Simulation.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수도요금경쟁_D2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int P = Integer.parseInt(stringTokenizer.nextToken()); //9
            int Q = Integer.parseInt(stringTokenizer.nextToken()); //100
            int R = Integer.parseInt(stringTokenizer.nextToken()); //20
            int S = Integer.parseInt(stringTokenizer.nextToken()); //3
            int W = Integer.parseInt(stringTokenizer.nextToken()); //10

            // A사는 1리터당 P 요금
            // B사는 R까진 기본요금 Q, R부터 1리터당 S 요금
            // W는 내가 사용하는 양

            int A = P * W; // p*w
            int B = 0;
            if(R < W){ //기본 제공보다 사용량이 많을 경우
                int use = W - R;
                int cost = use * S;
                B = cost + Q;
            }else{
                B = Q;
            }

            if(A > B){
                System.out.println("#" + test_case + " " + B);
            }else{
                System.out.println("#" + test_case + " " + A);
            }
        }
    }
}
