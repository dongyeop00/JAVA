package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        long A = Long.parseLong(stringTokenizer.nextToken());
        long B = Long.parseLong(stringTokenizer.nextToken());

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(A, 1));

        while(!queue.isEmpty()){
            Point p = queue.poll();
            long num = p.current;
            int count = p.count;

            if(num == B){
                System.out.println(count);
                return;
            }

            if(num*2 <= B){
                queue.add(new Point(num*2, count+1));
            }
            if(num*10+1 <= B) {
                queue.add(new Point(num * 10 + 1, count + 1));
            }
        }
        System.out.println(-1);
    }

    private static class Point{
        long current;
        int count;

        Point(long current, int count){
            this.current = current;
            this.count = count;
        }
    }
}
