package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 알고스탁 {
		//	 예치금, 불입금액, 종목수, 데이터기간
	static int ms, ma, N, L;
	static int[][] stockCost;
	static int maxMoney, maxBenefit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			ms = Integer.parseInt(st.nextToken());
			ma = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			stockCost = new int[N][L+1];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<L+1; j++) {
					stockCost[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int money = ms;
			
			for(int i=0; i<L; i++) {
				List<Stock> stockList = new ArrayList<>(); 
				
				for(int j=0; j<N; j++) {
					if(stockCost[j][i] < stockCost[j][i+1]) {
						stockList.add(new Stock(stockCost[j][i], stockCost[j][i+1] - stockCost[j][i]));
					}
				}
				
				maxBenefit = 0;
				
				DFS(0, money, 0, stockList);
				
				money += maxBenefit;
				money += ma;
			}
			
			int result = money - ms - (ma * L);
			System.out.println("#" + testCase + " " + result);
		}
	}
	
	public static void DFS(int index, int currentMoney, int benefit, List<Stock> stockList) {
		if(index == stockList.size()) {
			maxBenefit = Math.max(maxBenefit, benefit);
			return;
		}
		
		// 현재 이득보는 주식
		Stock current = stockList.get(index);
		
		// 주식 삼
		if(currentMoney >= current.currentPrice) {
			DFS(index, currentMoney - current.currentPrice, benefit + current.diff, stockList);
		}
		
		DFS(index+1, currentMoney, benefit, stockList);
	
	}
	
	public static class Stock{
		int currentPrice;
		int diff;
		
		Stock(int currentPrice, int diff){
			this.currentPrice = currentPrice;
			this.diff = diff;
		}
	}

}
