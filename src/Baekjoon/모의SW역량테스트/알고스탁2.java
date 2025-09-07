package Baekjoon.모의SW역량테스트;

import java.util.*;
import java.io.*;

public class 알고스탁2 {

    // result = 최대 금액 - (예치금 + 불입금액 * 데이터기간)
    static int Ms, Ma; // 예치금, 월별 불입금액
    static int N, L; // 종목 수, 데이터 기간
    static int maxbenefit; // 최대 이익금
    static int[][] data;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            st = new StringTokenizer(br.readLine());

            Ms = Integer.parseInt(st.nextToken());
            Ma = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            data = new int[N][L+1];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<L+1; j++){
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int money = Ms;
            maxbenefit = Integer.MIN_VALUE;

            // 월 별 이득나는 종목 구하기
            for(int i=0; i<L; i++){
                List<Stock> list = new ArrayList<>();
                for(int j=0; j<N; j++){
                    if(data[j][i] < data[j][i+1]){
                        int currentPrice = data[j][i];
                        int nextPrice = data[j][i+1];
                        int benefit = nextPrice - currentPrice;
                        list.add(new Stock(currentPrice, nextPrice, benefit));
                    }
                }

                // 이번달에 얻을 수 있는 최대 금액
                maxbenefit = 0;

                dfs(money, 0, 0, list);

                money += maxbenefit;
                money += Ma;
            }

            int result = money - Ms - (Ma * L);
            System.out.println("#" + testCase + " " + result);
        }
    }

    /**
     *
     * @param money : 현재 보유 금액
     * @param benefit : 이익 금액
     * @param index : 구매할 종목 번호
     * @param list : 이익나는 종목들의 리스트
     */

    public static void dfs(int money, int benefit, int index, List<Stock> list){
        if(index == list.size()){
            maxbenefit = Math.max(maxbenefit, benefit);
            return;
        }

        Stock current = list.get(index);

        // 살 수 있다면 계속 구입
        if(money >= current.currentPrice){
            dfs(money - current.currentPrice, benefit + current.benefit, index, list);
        }

        // 구입 안함
        dfs(money, benefit, index+1, list);
    }

    public static class Stock{
        int currentPrice;
        int nextPrice;
        int benefit;

        Stock(int currentPrice, int nextPrice, int benefit){
            this.currentPrice = currentPrice;
            this.nextPrice = nextPrice;
            this.benefit = benefit;
        }
    }
}
