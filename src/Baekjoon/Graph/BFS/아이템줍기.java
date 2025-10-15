package Baekjoon.Graph.BFS;

import java.util.*;

public class 아이템줍기 {
	
	static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
		int characterX = 1, characterY = 3;
		int itemX = 7, itemY = 8;
		
		System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
	}
	
	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		map = new int[101][101];
		
		fillMap(rectangle);
		

		return BFS(rectangle, characterX, characterY, itemX, itemY);
	}
	
	public static int BFS(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		Queue<Position> queue = new LinkedList<>();
		boolean[][] visited = new boolean[101][101];
		
		queue.offer(new Position(characterX * 2, characterY * 2, 0));
		visited[characterX * 2][characterY * 2] = true;
		
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			
			if(current.x == itemX * 2 && current.y == itemY * 2) {
				return current.distance / 2;
			}
			
			for(int i=0; i<4; i++) {
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];
				
				if(newX < 0 || newY < 0 || newX >= 101 || newY >= 101) continue;
				if(visited[newX][newY]) continue;
				if(map[newX][newY] != 1) continue;
				
				visited[newX][newY] = true;
				queue.offer(new Position(newX, newY, current.distance+1));
			}
		}
		
		
		return 0;
	}
	
	public static void fillMap(int[][] rectangle) {
		for(int[] array : rectangle) {
			int sx = array[0] * 2;
			int sy = array[1] * 2;
			int ex = array[2] * 2;
			int ey = array[3] * 2;
			
			for(int x=sx; x<=ex; x++) {
				for(int y=sy; y<=ey; y++) {
					if(map[x][y] == 2) continue;
					map[x][y] = 2;
					if(x == sx || x == ex || y == sy || y == ey) map[x][y] = 1;
				}
			}
		}
	}
	
	public static class Position{
		int x;
		int y;
		int distance;
		
		Position(int x, int y, int distance){
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}


}
