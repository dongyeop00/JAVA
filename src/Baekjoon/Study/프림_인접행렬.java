package Baekjoon.Study;

import java.util.Arrays;

public class 프림_인접행렬 {

    static int N = 7;

    public static void main(String[] args) {
        int[][] map = new int[N][N];
        setMap(map);

        // 방문배열
        boolean[] visited = new boolean[N];

        // 거리배열
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 임의의 정점
        distance[0] = 0;

        // 프림 로직을 정점-1(간선의수) 번만큼 반복한다.
        for(int cnt=0; cnt<N-1; cnt++){
            // 기준 정점
            int minIdx = -1;
            int minDis = Integer.MAX_VALUE;

            // 방문하지 않은 정점 중 최소 거리 정점 찾기
            for(int i=0; i<distance.length; i++){
                if(!visited[i] && distance[i] < minDis){
                    minIdx = i;
                    minDis = distance[i];
                }
            }

            // minIdx : 방문하지 않은 정점 중 최소 거리 값을 갖는 정점 번호
            visited[minIdx] = true;

            //기준 정점과 연결된 간선의 값을 거리배열에 업데이트 한다.
            // i : 연결될 정점
            for(int i=0; i<visited.length; i++){
                // 기준 정점과 타겟 정점이 연결되어 있고
                // 타겟 정점이 방문되지 않았으며
                // 새롭게 찾은 간선이 기존에 찾은 값보다 작다면
                if(map[minIdx][i] != 0 && !visited[i] && map[minIdx][i] < distance[i]) {
                    // 새롭게 찾은 간선의 가중치를 거리배열에 업데이트 한다.
                    distance[i] = map[minIdx][i];
                }
            }
        }

        System.out.println(Arrays.toString(distance));
    }

    public static void setMap(int[][] map){
        map[0][1] = 2;
        map[1][0] = 2;

        map[0][2] = 4;
        map[2][0] = 4;

        map[0][5] = 8;
        map[5][0] = 8;

        map[1][2] = 1;
        map[2][1] = 1;

        map[1][3] = 19;
        map[3][1] = 19;

        map[2][5] = 5;
        map[5][2] = 5;

        map[3][5] = 11;
        map[5][3] = 11;

        map[3][4] = 7;
        map[4][3] = 7;

        map[3][6] = 15;
        map[6][3] = 15;

        map[4][6] = 3;
        map[6][4] = 3;

        map[5][4] = 9;
        map[4][5] = 9;
    }
}
