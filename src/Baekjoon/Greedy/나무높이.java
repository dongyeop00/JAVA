package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무높이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=TC; testCase++){
            int N = Integer.parseInt(br.readLine());
            int maxHeight = Integer.MIN_VALUE;
            int answer = Integer.MAX_VALUE;
            int[] trees = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, trees[i]);
            }

            answer = watering(trees, N, maxHeight);
            /*
            1
            6
            1 1 1 1 1 3인 경우
            9일이 걸린다.
            그러나 첫날 크기가 2인 나무에 물을 주어서 3을 만든다.
            그리고 홀수날과 짝수날 물을 주어서 8일만에 가능하다.
             */
            answer = Math.min(answer, watering(trees, N, maxHeight+1));
            System.out.println("#" + testCase + " " + answer);
        }
    }

    private static int watering2(int[] trees, int N, int maxHeight){
        int days = 0, ones = 0, twos = 0;

        for(int i=0; i<N; i++){
            ones += (maxHeight - trees[i]) % 2;
            twos += (maxHeight - trees[i]) / 2;
        }

        int mins = Math.min(ones, twos);
        ones -= mins;
        twos -= mins;
        days += mins * 2;

        if(twos == 0){
            days += 2 * ones - 1;
        }

        if(ones == 0){
            days += twos + 1 + (twos-1)/3;
        }

        return days;
    }

    private static int watering(int[] trees, int N, int maxHeight){
        int days = 0, ones = 0, twos = 0;

        // ones : 1 홀수날
        // twos : 2 짝수날
        for(int i=0; i<N; i++){
            ones += (maxHeight - trees[i]) % 2;
            twos += (maxHeight - trees[i]) / 2;
        }

        /*
        공통으로 커야되는 날을 빼고
         */
        int mins = Math.min(ones, twos);
        ones -= mins;
        twos -= mins;

        /*
        뺀 날만큼 days에 추가한다.
         */

        days += mins * 2;

        /*
        이제 공통으로 커야되는 날은 빠졌다.
        그래서 홀수날 커야되는 나무이거나 짝수날 커야되는 나무만 남았으니 이를 처리 한다.
        2일씩 커야되는 날이 0이면, 다시 말해 홀수날 커야되는 날만 남았으면
        1cm 남았을 경우 필요한 날 1일
        2cm 남았을 경우 필요한 날 3일
        3cm 남았을 경우 필요한 날 5일
        4cm 남았을 경우 필요한 날 7일
        f(n) = 2n - 1
         */
        if(twos == 0){
            days += 2 * ones - 1;
        }

        /*
        그래서 홀수 날 커야되는 나무이거나 짝수날 커야되는 나무만 남았으니 이를 처리한다.
        1일씩 커야되는 날이 0이면, 다시 말해 짝수날 커야되는 날만 남앗으면
        2cm 남았을 경우 필요한 날 2일 필요 => 1 2 (2일날만 물을 준다)
        4cm 남았을 경우 필요한 날 3일 필요 => 1 2 1 (1,2,3일날 물을 준다)
        6cm 남았을 경우 필요한 날 4일 필요 => 1 2 1 2
        8cm 남았을 경우 필요한 날 6일 필요 => 1 2 1 2 0 2 (1, 2,3,4,6일날 물을 준다.)
        f(n) = n + 1 + (n-1)/3
         */
        if(ones == 0){
            days += twos + 1 + (twos-1)/3;
        }

        return days;
    }
}
