package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] area = new int[M];

        for(int i=0; i<M; i++){
            area[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(N, M, area);
        System.out.println(result);
    }

    private static int solution(int N, int M, int[] area){
        int canFill = 0;

        // 1 ~ M-1 범위까지 해당 높이에서 얼마나 많이 쌓을 수 있는지 판단
        // 해당 높이에서 왼쪽의 최대 높이, 오른쪽의 최대 높이를 구함 -> min(왼쪽 최대 높이, 오른쪽의 최대 높이)
        // 단 해당 높이가 최대 높이면 못채움
        for(int i=1; i<M-1; i++){
            int leftHight = 0;
            int rightHight = 0;

            // 왼쪽의 최대 높이를 구함
            for(int left=i; left>=0; left--){
                leftHight = Math.max(leftHight, area[left]);
            }

            // 오른쪽의 최대 높이를 구함
            for(int right=i; right<M; right++){
                rightHight = Math.max(rightHight, area[right]);
            }

            // 채울 수 있는 물 = min(왼쪽높이, 오른쪽높이) - 현재 높이
            canFill += Math.min(leftHight, rightHight) - area[i];

        }
        return canFill;
    }
}
