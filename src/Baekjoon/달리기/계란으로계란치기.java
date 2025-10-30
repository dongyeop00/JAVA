package Baekjoon.달리기;

import java.util.*;
import java.io.*;

public class 계란으로계란치기 {

	static int N, maxCount = Integer.MIN_VALUE;
	static Egg[] eggs;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int hp = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			eggs[i] = new Egg(hp, weight);
		}
		
		backTracking(0);
		System.out.println(maxCount);
	}
	
	public static void backTracking(int index) {
		/*
		 * 	1. 가장 왼쪽의 계란을 든다.
			2. 손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다. 
				2.1 단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다. 
				2.2 이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
			3. 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다.
				3.1 단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.
		 */
		
		// 3.1 단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란 치는 과정을 종료한다.
		if(index == N) {
			maxCount = Math.max(maxCount, count());
			return;
		}
		
		// 1. 가장 왼쪽의 계란을 든다.
		Egg current = eggs[index];
		
		if(current.hp <= 0) {
			backTracking(index+1);
			return;
		}
		
		boolean hitEgg = false;
		
		// 2. 손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다.
		for(int i=0; i<N; i++) {
			// 내가 나 자신을 치면 패스
			if(index == i) continue;
	
			// 다른 계란 선택
			Egg next = eggs[i];
			
			// 선택할 계란이 깨져있으면 패스
			if(next.hp <= 0) continue;
			
			current.hp -= next.weight;
			next.hp -= current.weight;
			
			hitEgg = true;
			
			backTracking(index+1);
			
			current.hp += next.weight;
			next.hp += current.weight;
		}
		
		if(!hitEgg) {
			backTracking(index+1);
		}
		
		
	}
	
	public static int count() {
		int count = 0;
		for(int i=0; i<N; i++) {
			if(eggs[i].hp <= 0) {
				count++;
			}
		}
		return count;
	}
	
	public static class Egg{
		int hp;
		int weight;
		
		Egg(int hp, int weight){
			this.hp = hp;
			this.weight = weight;
		}
	}

}
