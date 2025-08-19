package Baekjoon.Greedy;

import java.util.*;
import java.io.*;

public class 회의실배정 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Room> queue = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			queue.offer(new Room(start, end));
		}
		
		Room temp = queue.poll();
		
		int endTime = temp.end;
		int count = 1;
		
		while(!queue.isEmpty()) {
			Room current = queue.poll();
			
			int startTime = current.start;
			
			if(endTime > startTime) {
				continue;
			}else {
				count++;
				endTime = current.end;
			}
		}
		
		System.out.println(count);
	}
	
	public static class Room implements Comparable<Room>{
		
		int start;
		int end;
		
		Room(int start, int end){
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Room o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			
			return this.end - o.end;
		}
		
	}
}
