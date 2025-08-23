package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 알고스탁 {

    static int S, A, N, L, maxBenefit;
    static int[][] cost, win;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            st = new StringTokenizer(br.readLine());

            S = Integer.parseInt(st.nextToken()); //초기 자본
            A = Integer.parseInt(st.nextToken()); // 매달 추가 입금액

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 종목 개수
            L = Integer.parseInt(st.nextToken()); // 총 개월 수

            cost = new int[N][L+1];
            win = new int[N][L+1];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<=L; j++){
                    cost[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 현재 금액
            int money = S;

            for(int month=0; month < L; month++){
                // 구매 리스트 (이익나는 종목 리스트)
                List<Stock> stockList = new ArrayList<>();

                for(int i=0; i<N; i++){
                    // 현재 달보다 다음 달에 주식이 오르면 리스트에 저장
                    if(cost[i][month] < cost[i][month+1]){
                        stockList.add(new Stock(cost[i][month], cost[i][month+1], cost[i][month+1] - cost[i][month]));
                    }
                }

                // 이번달에 얻을 수 있는 최대 이익
                maxBenefit = 0;

                // 만약 구매할 종목이 여러개라면 최대 이익 찾기를 한다(조합)
                dfs(0, money, 0, stockList);

                money += maxBenefit;
                money += A;
            }

            // 모든달의 최대이익금액을 구매했다면
            // 최대이익금액 - 초기금액 - 월별 불입금을 계산한다.
            int result = money - S - (A*L);
            System.out.println("#" + testCase + " " + result);
        }
    }

                        //  구매할종목번호 현재잔액    이익금       구매종목리스트
    private static void dfs(int index, int money, int benefit, List<Stock> stockList){
        // base part
        // 구매하려는 종목을 모두 살펴봤으면 계산하고 탈출
        if(index == stockList.size()){
            // 현재 재귀에서 얻은 이익이 최대치인지 비교하여 저장
            maxBenefit = Math.max(maxBenefit, benefit);
            return;
        }

        // inductive part
        Stock stock = stockList.get(index);

        // 1. 종목을 구매한다면 한 주를 사고 다음 재귀로 넘어간다.
        if(money >= stock.currentPrice){
            dfs(index, money - stock.currentPrice, benefit + stock.diff, stockList);
        }

        // 2. 종목을 구매하지 않는다면 다음 종목으로 넘긴다.
        dfs(index+1, money, benefit, stockList);
    }

    public static class Stock{
        int currentPrice; // 현재 금액
        int nextPrice;
        int diff; // 차익(이익)

        Stock(int currentPrice, int nextPrice, int diff){
            this.currentPrice = currentPrice;
            this.nextPrice = nextPrice;
            this.diff = diff;
        }
    }
}
