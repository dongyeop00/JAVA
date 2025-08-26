package Baekjoon.Study;

import java.util.*;
import java.io.*;

public class 크루스칼 {
	// Union Find
	static Edge[] edgeList;
	static int[] parents;
	static int V, E;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V];
		edgeList = new Edge[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgeList);
		make();
		
		int result = 0; // 최소 신장 트리 비용
		int cnt = 0; //처리된 간선 개수
		
		for(Edge edge : edgeList) {
			if(!union(edge.from, edge.to)) continue; // union 실패 : 사이클 발생
			result += edge.weight;
			if(++cnt == V-1) break;
		}
		
		System.out.println(result);
	}
	
	private static void make() {
		for(int i=0; i<V; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		if(aRoot>bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
		
		return true;
	}
	
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// 10 - 20 : 음수 -> 뒤 값이 크다 : 그럼 그대루 위치 (교환이 일어나지 않음)
			// 20 - 10 : 양수 -> 앞 값이 크다 : 교환
			return Integer.compare(this.weight, o.weight);
		}
	}
}
