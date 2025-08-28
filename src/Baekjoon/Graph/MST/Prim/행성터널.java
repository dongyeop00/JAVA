package Baekjoon.Graph.MST.Prim;

import java.util.*;
import java.io.*;

public class 행성터널 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			nodes[i] = new Node(i, x, y, z);
		}
		
		Node[] xs = nodes.clone();
		Node[] ys = nodes.clone();
		Node[] zs = nodes.clone();
		
		// x, y, z 순으로 정렬
		// 정렬하는 이유는?
		// 정점 n개를 가진 무방향 완전 그래프의 최대 간선 수 = n(n-1)/2
		// 100,000(100,000 - 1) / 2 = 약 50억
		// 모든 정점에 대해 거리를 구하려면 50억개의 간선이 생기기 때문에 정렬이 필요함
		// 축 별로 정렬하여 이웃만 연결한다.
		// x[i], x[i+1], x[i+2]로 정렬하면 x[i], x[i+1]만 간선으로 연결한다.
		// 왜냐면 x[i], x[i+2]는 비용이 더 클 수밖에 없고, 기존 mst라면 x[i], x[i+1]을 통해 만들어짐
		// 따라서 축별 정렬, 인접한 점들만 연결 -> N-1쌍이 만들어짐
		// 기존은 인접한 점들이 아닌 모든 점들을 연결하니 n(n-1)/2 개수가 만들어짐
		// 따라서 n(n-1)/2 -> 3(n-1)이 됨
        Arrays.sort(xs, new Comparator<Node>() {
            @Override public int compare(Node a, Node b) { return a.x - b.x; }
        });
        Arrays.sort(ys, new Comparator<Node>() {
            @Override public int compare(Node a, Node b) { return a.y - b.y; }
        });
        Arrays.sort(zs, new Comparator<Node>() {
            @Override public int compare(Node a, Node b) { return a.z - b.z; }
        });
				
        List<List<Edge>> graph = new ArrayList<>();
        for(int i=0; i<N; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<N-1; i++) {
        	int from = xs[i].index;
        	int to = xs[i+1].index;
        	int weight = Math.abs(xs[i].x - xs[i+1].x);
        	graph.get(from).add(new Edge(to, weight));
        	graph.get(to).add(new Edge(from, weight));
        	
        	from = ys[i].index;
        	to = ys[i+1].index;
        	weight = Math.abs(ys[i].y - ys[i+1].y);
        	graph.get(from).add(new Edge(to, weight));
        	graph.get(to).add(new Edge(from, weight));
        	
        	from = zs[i].index;
        	to = zs[i+1].index;
        	weight = Math.abs(zs[i].z - zs[i+1].z);
        	graph.get(from).add(new Edge(to, weight));
        	graph.get(to).add(new Edge(from, weight));
        }
        
        // 프림 알고리즘
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        long total = 0;
        int pick = 0;
        
        visited[0] = true;
        for(Edge e : graph.get(0)) {
        	queue.offer(e);
        }
        
        while(!queue.isEmpty() && pick < N-1) {
        	Edge current = queue.poll();
        	
        	if(visited[current.to]) continue;
        	visited[current.to] = true;
        	total += current.weight;
        	pick++;
        	
        	for(Edge next : graph.get(current.to)) {
        		if(!visited[next.to]) {
        			queue.offer(next);
        		}
        	}
        }
        
		System.out.println(total);
	}
	
	public static class Node{
		int index;
		int x;
		int y;
		int z;
		
		Node(int index, int x, int y, int z){
			this.index = index;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int to;
		long weight;
		
		public Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight, o.weight);
		}
	}
}
