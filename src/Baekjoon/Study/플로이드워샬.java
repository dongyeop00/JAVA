package Baekjoon.Study;

public class 플로이드워샬 {
	
	static final int INF = 1_000_000_000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 4; // 정점 수
		int[][] dist = {
				{0, 5, INF, 8},
				{7, 0, 9, INF},
				{2, INF, 0, 4},
				{INF, INF, 3, 0}
		};
		
		// 플로이드 워샬
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		// 결과
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dist[i][j] == INF) System.out.print("INF ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
		
        System.out.println("-----");
        
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		        if (dist[i][j] == INF) {
		            System.out.printf("%d -> %d : INF%n", i, j);
		        } else {
		            System.out.printf("%d -> %d : %d%n", i, j, dist[i][j]);
		        }
		    }
		}
	}
}
