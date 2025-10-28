package Baekjoon.모의SW역량테스트;

// x시간 동안 비활성 상태이고 x시간이 지나는 순간 활성 상태가 된다.
// x시간 동안 살아있을 수 있으며 x시간이 지나면 세포는 죽게 된다.
// 두 개 이상의 줄기 세포가 하나의 셀에 동시 번식하려고 하는 경우 생명력 수치가 높은 줄기 세포가 해당 그리드 셀을 혼자서 차지
// K시간 후 살아있는 줄기세포의 총 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 줄기세포배양 {

    static int N, M, K;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Position> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            queue = new LinkedList<>();

            // 번식 최대 K칸 가능 -> 상하좌우 2 * K 칸 확장
            map = new int[N + 2 * K][M + 2 * K];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int hp = Integer.parseInt(st.nextToken());
                    if (hp > 0) {
                        int x = i + K;
                        int y = j + K;
                        map[x][y] = hp; // 중앙 배치
                        queue.offer(new Position(x, y, false, hp, hp)); // 비활성으로 시작
                    }
                }
            }

            BFS();
            System.out.println("#" + testCase + " " + queue.size());
        }
    }

    static public void BFS() {
        int time = 0;

        // K시간이 지나거나 더 이상 세포가 없을 때까지 반복
        while (time < K && !queue.isEmpty()) {
            int size = queue.size();

            // 이번 턴(1시간) 동안 새로 생길 세포들을 임시 저장할 맵
            // 동일한 위치에 여러 세포가 번식하려 할 경우,
            // 생명력(hp)이 높은 세포만 남기기 위함
            Map<String, Position> newCells = new HashMap<>();

            // 현재 시간대의 세포들을 모두 처리
            for (int i = 0; i < size; i++) {
                Position now = queue.poll();

                // 1️⃣ 비활성 상태인 경우
                if (!now.state) {
                    now.time--; // 비활성 시간 1 감소

                    // 비활성 시간이 끝나면 활성 상태로 전환
                    if (now.time == 0) {
                        now.state = true;
                        now.time = now.hp; // 활성 상태에서 살 수 있는 시간 초기화
                    }
                    // 아직 살아있으므로 다시 큐에 넣음
                    queue.add(now);
                }
                // 2️⃣ 활성 상태인 경우
                else {
                    // 활성화된 첫 번째 시간(즉, now.time == hp)일 때만 번식 가능
                    if (now.time == now.hp) {
                        for (int d = 0; d < 4; d++) {
                            int nx = now.x + dx[d];
                            int ny = now.y + dy[d];

                            // 기존 맵에서 아직 세포가 없는 칸만 번식 가능
                            if (map[nx][ny] == 0) {
                                String key = nx + "," + ny;

                                // 동일 좌표에 번식하려는 다른 세포가 있다면
                                // 생명력이 높은 세포만 남김
                                Position exist = newCells.get(key);
                                if (exist == null || exist.hp < now.hp) {
                                    newCells.put(key, new Position(nx, ny, false, now.hp, now.hp));
                                }
                            }
                        }
                    }

                    // 활성 상태로 생존 중일 경우 남은 시간 감소
                    now.time--;

                    // 아직 활성 상태의 수명이 남아 있다면 큐에 유지
                    if (now.time > 0) {
                        queue.add(now);
                    }
                    // time == 0이면 사망 → 큐에 다시 넣지 않음
                }
            }

            // 이번 턴에서 새로 번식한 세포들을 맵과 큐에 반영
            for (Position newCell : newCells.values()) {
                map[newCell.x][newCell.y] = newCell.hp; // 맵에 생명력 기록
                queue.add(newCell);                     // 큐에 추가하여 다음 턴부터 관리
            }

            // 1시간 경과
            time++;
        }
    }


    static class Position {
        int x, y;
        boolean state; // false: 비활성, true: 활성
        int hp;        // 생명력
        int time;      // 해당 단계 남은 시간(비활성/활성)

        public Position(int x, int y, boolean state, int hp, int time) {
            this.x = x;
            this.y = y;
            this.state = state;
            this.hp = hp;
            this.time = time;
        }
    }
}
