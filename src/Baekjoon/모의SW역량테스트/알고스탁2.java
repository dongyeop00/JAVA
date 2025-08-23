package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 알고스탁2 {

    static int S, A, N, L, maxBenefit;
    static int[][] cost;

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

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<L+1; j++){
                    cost[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int money = S;

            for(int month=0; month<L; month++){
                List<Stock> stockList = new ArrayList<>();

                for(int i=0; i<N; i++){
                    if(cost[i][month] < cost[i][month+1]){ //현재 달과 다음 달과 비교
                        stockList.add(new Stock(cost[i][month], cost[i][month+1], cost[i][month+1] - cost[i][month]));
                    }
                }

                maxBenefit = 0;

                dfs(0, money, 0, stockList);

                money += maxBenefit;
                money += A;
            }

            int result = money - S - (A*L);
            System.out.println(result);
        }
    }

    public static void dfs(int index, int money, int benefit, List<Stock> list){
        if(index == list.size()){
            maxBenefit = Math.max(benefit, maxBenefit);
            return;
        }

        Stock current = list.get(index);

        if(money >= current.current){
            dfs(index, money - current.current, benefit + current.diff, list);
        }

        dfs(index+1, money, benefit, list);
    }

    public static class Stock{
        int current;
        int next;
        int diff;

        Stock(int current, int next, int diff){
            this.current = current;
            this.next = next;
            this.diff = diff;
        }
    }
}
