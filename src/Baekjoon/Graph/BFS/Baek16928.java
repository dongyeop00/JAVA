package Baekjoon.Graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek16928 {

    static int ladder, snake;
    static Map<Integer, Integer> ladderMap, snakeMap;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        ladder = Integer.parseInt(stringTokenizer.nextToken());
        snake = Integer.parseInt(stringTokenizer.nextToken());

        ladderMap = new HashMap<>();
        snakeMap = new HashMap<>();

        visited = new boolean[101];

        for(int i=0; i<ladder; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            ladderMap.put(start, end);
        }

        for(int i=0; i<snake; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            snakeMap.put(start, end);
        }

        int result = BFS(1);
        System.out.println(result);
    }

    private static int BFS(int start){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start, 0));
        visited[start] = true;

        while(!queue.isEmpty()){
            Point current = queue.poll();

            //조건 검사
            if(current.location == 100){
                return current.count;
            }

            // 주사위 1~6까지 던지기
            for(int i=1; i<=6; i++){
                int next = current.location + i;

                if(next > 100 || visited[next]){
                    continue;
                }

                //사다리타기
                if(ladderMap.containsKey(next)){
                    next = ladderMap.get(next);
                }

                //뱀타기
                if(snakeMap.containsKey(next)){
                    next = snakeMap.get(next);
                }

                visited[next] = true;
                queue.offer(new Point(next, current.count+1));
            }
        }

        return 0;
    }

    private static class Point{
        int location;
        int count;
        Point(int location, int count){
            this.location = location;
            this.count = count;
        }
    }
}
