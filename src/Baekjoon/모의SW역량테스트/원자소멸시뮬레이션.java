package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 원자소멸시뮬레이션 {

    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static List<Atomic> atomics;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            N = Integer.parseInt(br.readLine());

            atomics = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());

                // 좌표를 2배로 확대 (0.5 단위 이동을 정수로 처리)
                x = 2 * (x + 1000);
                y = 2 * (y + 1000);

                atomics.add(new Atomic(x, y, dir, power));
            }

            int sum = 0;
            int time = 0;

            while (!atomics.isEmpty() && time < 4000) {
                time++;

                // 1. 이동하기 - 역순 반복문으로 안전한 제거
                for (int i = atomics.size() - 1; i >= 0; i--) {
                    Atomic atomic = atomics.get(i);

                    int nextX = atomic.x + dx[atomic.dir];
                    int nextY = atomic.y + dy[atomic.dir];

                    // 범위를 벗어나면 제거
                    if (nextX < 0 || nextY < 0 || nextX > 4000 || nextY > 4000) {
                        atomics.remove(i);
                    } else {
                        atomic.x = nextX;
                        atomic.y = nextY;
                    }
                }

                // 원자가 1개 이하면 충돌 불가능
                if (atomics.size() <= 1) break;

                // 2. 충돌 검사 - HashMap으로 같은 위치의 원자들 그룹화
                Map<Long, List<Atomic>> positionMap = new HashMap<>();

                for (Atomic atomic : atomics) {
                    long key = ((long)atomic.x << 20) | atomic.y;
                    positionMap.computeIfAbsent(key, k -> new ArrayList<>()).add(atomic);
                }

                // 3. 충돌 처리
                List<Atomic> survivors = new ArrayList<>();
                for (List<Atomic> group : positionMap.values()) {
                    if (group.size() == 1) {
                        survivors.add(group.get(0)); // 충돌하지 않은 원자
                    } else {
                        // 충돌한 원자들의 에너지 합산
                        for (Atomic atomic : group) {
                            sum += atomic.power;
                        }
                    }
                }
                atomics = survivors;
            }

            System.out.println("#" + testCase + " " + sum);
        }
    }

    public static class Atomic {
        int x, y, dir, power;

        Atomic(int x, int y, int dir, int power) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.power = power;
        }
    }
}