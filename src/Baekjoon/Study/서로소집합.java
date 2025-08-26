package Baekjoon.Study;

import java.util.Arrays;

/*
 * 서로소집합
 * 집합을 하나의 노드로 보고 집합을 그래프로 만드는 알고리즘
 * 
 */

public class 서로소집합 {

	static int[] parents;
	static int[] rank;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 6개의 집합이 있습니다.
		// 6개의 집합의 대표자를 정합니다.
		parents = new int[6];
		
		//각 집합의 높이를 저장할 배열을 선언합니다.
		rank = new int[6];
		
		//대표자를 선발합니다. (makeSet)
		for(int i=0; i<parents.length; i++) {
			parents[i] = i;
		}
		
		unionSet(0, 3);
		unionSet(1, 2);
		unionSet(0, 2);
		
		for(int i=0; i<6; i++) {
			System.out.println(findSet(i));
		}
		
		System.out.println(Arrays.toString(parents));
	}

	private static void unionSet(int i, int j) {
		int iRoot = findSet(i);
		int jRoot = findSet(j);
		
		// iRoot가 jRoot 밑으로 들어갑니다.
		parents[iRoot] = jRoot;
		
		// rank
		// 집합의 높이가 낮은 집합이 높이가 높은 집합 밑으로 들어간다.
		if(rank[iRoot] > rank[jRoot]) {
			parents[jRoot] = iRoot;
		}else {
			parents[iRoot] = jRoot;
			//만약 두 집합의 높이가 같다면
			if(rank[iRoot] == rank[jRoot]) {
				rank[jRoot]++;
			}
		}
	}

	private static int findSet(int i) {
		if(parents[i] == i) return i;
		return findSet(parents[i]);
	}

}
