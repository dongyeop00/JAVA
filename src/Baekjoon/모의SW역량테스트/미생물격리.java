package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미생물격리 {

    static int N, M, K;
    static List<Bug> list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                list.add(new Bug(x, y, cnt, dir));
            }

            for(int i=0; i<M; i++) {

                // 미생물 이동
                moveBug();

                // 미생물 삭제
                removeBug();

                // 미생물 합체
                unionBug();
            }

            System.out.println("#" + testCase + " " + count());
        }
    }

    public static void moveBug(){
        for(Bug bug : list){
            bug.x += dx[bug.dir - 1];
            bug.y += dy[bug.dir - 1];
        }
    }

    public static void removeBug(){
        for(int i=list.size()-1; i>=0; i--){
            Bug bug = list.get(i);

            if(bug.x == 0 || bug.y == 0 || bug.x == N-1 || bug.y == N-1) {
                bug.cnt /= 2;
                if(bug.dir == 1) bug.dir = 2;
                else if(bug.dir == 2) bug.dir = 1;
                else if(bug.dir == 3) bug.dir = 4;
                else bug.dir = 3;
            }

            if(bug.cnt == 0) list.remove(i);
        }
    }

    public static void unionBug(){
        // 좌표별 버그 위치
        Map<Integer, List<Bug>> map = new HashMap<>();

        // 새로운 합친 뒤 리스트
        List<Bug> next = new ArrayList<>();

        // 좌표별 버그들 놓기
        for(Bug bug : list){
            int key = bug.x * N + bug.y;
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(bug);
        }

        for(List<Bug> group : map.values()){
            // 해당 좌표에 대해 버그가 1개가 없으면 그 1개 추가
            if(group.size() == 0){
                next.add(group.get(0));
            }else {
                int sum = 0;
                Bug maxBug = null;

                for (Bug bug : group) {
                    sum += bug.cnt;

                    if (maxBug == null || maxBug.cnt < bug.cnt) {
                        maxBug = bug;
                    }
                }

                maxBug.cnt = sum;
                next.add(maxBug);
            }
        }

        list = next;
    }

    public static int count(){
        int count = 0;

        for(Bug bug : list){
            count += bug.cnt;
        }

        return count;
    }

    public static class Bug{
        int x, y, cnt, dir;

        Bug(int x, int y, int cnt, int dir){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
    }
}
