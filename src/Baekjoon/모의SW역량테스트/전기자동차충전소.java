package Baekjoon.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전기자동차충전소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++) {
            int N = Integer.parseInt(br.readLine());

            Home[] homes = new Home[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                homes[i] = new Home(x, y, d);
            }

            int result = Integer.MAX_VALUE;

            for (int x = -15; x <= 15; x++) {
                for (int y = -15; y <= 15; y++) {
                    boolean flag = true;
                    int sum = 0;

                    for(int i=0; i<N; i++){
                        int dist = dist(x, y, homes[i].x, homes[i].y);

                        if(homes[i].d < dist || dist == 0){
                            flag = false;
                            break;
                        }

                        sum += dist;
                    }

                    if(flag){
                        result = Math.min(result, sum);
                    }
                }
            }

            if(result != Integer.MAX_VALUE){
                System.out.println("#" + testCase+ " " + (result == Integer.MAX_VALUE ? -1 : result));
                continue;
            }

            for(int x1 = -15; x1 <= 15; x1++){
                for(int y1 = -15; y1 <= 15; y1++){
                    for(int x2 = -15; x2 <= 15; x2++){
                        for(int y2 = -15; y2 <= 15; y2++){
                            boolean flag = true;
                            int sum = 0;

                            for(int i=0; i<N; i++){
                                int dist1 = dist(x1, y1, homes[i].x, homes[i].y);
                                int dist2 = dist(x2, y2, homes[i].x, homes[i].y);
                                int minDist = Math.min(dist1, dist2);

                                if(homes[i].d < minDist || minDist == 0){
                                    flag = false;
                                    break;
                                }

                                sum += minDist;
                            }

                            if (flag){
                                result = Math.min(result, sum);
                            }
                        }
                    }
                }
            }

            System.out.println("#" + testCase + " " + (result == Integer.MAX_VALUE ? -1 : result));
        }
    }

    public static int dist(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static class Home{
        int x;
        int y;
        int d;

        Home(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
