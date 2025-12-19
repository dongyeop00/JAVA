package Baekjoon.Simulation;

import java.io.*;
import java.util.*;

public class 너의이름은 {

    static class Message {
        int nonRead;
        char people;

        Message(int nonRead, char people) {
            this.nonRead = nonRead;
            this.people = people;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Message[] messages = new Message[K + 1];
        boolean[] read = new boolean[26];

        // A는 항상 읽음
        read[0] = true;

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            char p = st.nextToken().charAt(0);
            messages[i] = new Message(r, p);
        }

        // Q번째 안 읽은 사람이 0이면 바로 종료
        if (messages[Q].nonRead == 0) {
            System.out.println(-1);
            return;
        }

        // Q번째 이후 메시지 보낸 사람은 모두 읽음
        for (int i = K; i >= Q; i--) {
            read[messages[i].people - 'A'] = true;
        }

        // R 값이 같은 구간 처리
        for (int i = Q; i > 1; i--) {
            if (messages[i].nonRead != messages[i - 1].nonRead) break;
            read[messages[i].people - 'A'] = true;
            read[messages[i - 1].people - 'A'] = true;
        }

        // 결과 출력
        boolean printed = false;
        for (int i = 0; i < N; i++) {
            if (!read[i]) {
                System.out.print((char) ('A' + i) + " ");
                printed = true;
            }
        }

        if (!printed) {
            System.out.println(-1);
        }
    }
}
