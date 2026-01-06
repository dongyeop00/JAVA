package Baekjoon.TreeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 근성아일하자 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());
        TreeSet<Integer> ts = new TreeSet<>();

        long total = 0;
        int guenseong = 0;

        for(int command=0; command<N; command++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int type = Integer.parseInt(stringTokenizer.nextToken());

            if(type == 1){
                int position = Integer.parseInt(stringTokenizer.nextToken());
                ts.add(position);
            }else{
                while(!ts.isEmpty()){
                    Integer right = ts.ceiling(guenseong);
                    Integer left = ts.floor(guenseong);

                    int target = 0;
                    if(left == null){ // 왼쪽이 비어있다면 오른쪽에는 쓰레기가 있다.
                        target = right;
                    }else if(right == null){ // 오른쪽이 비어있다면 왼쪽에는 쓰레기가 있다.
                        target = left;
                    }else{
                        int leftDistance = guenseong - left;
                        int rightDistance = right - guenseong;

                        if(leftDistance <= rightDistance){
                            target = left;
                        }else{
                            target = right;
                        }
                    }

                    total += Math.abs(guenseong - target);
                    guenseong = target;
                    ts.remove(target);
                }
            }
        }

        System.out.println(total);
    }
}
