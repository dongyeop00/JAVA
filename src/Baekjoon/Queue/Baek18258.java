package Baekjoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        Deque<Integer> myQueue = new ArrayDeque<>();
        int testCase = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < testCase; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            String command = stringTokenizer.nextToken();

            switch (command) {
                case "push":
                    int temp = Integer.parseInt(stringTokenizer.nextToken());
                    myQueue.offer(temp);
                    break;
                case "pop":
                    if (myQueue.isEmpty()) {
                        stringBuilder.append(-1).append('\n');
                    } else {
                        stringBuilder.append(myQueue.poll()).append('\n');
                    }
                    break;
                case "front":
                    if (myQueue.isEmpty()) {
                        stringBuilder.append(-1).append('\n');
                    } else {
                        stringBuilder.append(myQueue.peekFirst()).append('\n');
                    }
                    break;
                case "back":
                    if (myQueue.isEmpty()) {
                        stringBuilder.append(-1).append('\n');
                    } else {
                        stringBuilder.append(myQueue.peekLast()).append('\n');
                    }
                    break;
                case "size":
                    stringBuilder.append(myQueue.size()).append('\n');
                    break;
                case "empty":
                    if (myQueue.isEmpty()) {
                        stringBuilder.append(1).append('\n');
                    } else {
                        stringBuilder.append(0).append('\n');
                    }
                    break;
            }
        }

        System.out.print(stringBuilder);
    }
}
