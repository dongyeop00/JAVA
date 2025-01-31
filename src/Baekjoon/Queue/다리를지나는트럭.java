package Baekjoon.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights){
        int time = 0;
        int sum = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<truck_weights.length; i++){
            int truck = truck_weights[i];

            while(true){
                if(queue.isEmpty()){
                    queue.offer(truck);
                    sum += truck;
                    time++;
                    break;
                }else if(queue.size() == bridge_length){
                    sum -= queue.poll();
                }else{
                    if(sum + truck <= weight){
                        queue.offer(truck);
                        sum+=truck;
                        time++;
                        break;
                    }else{
                        queue.offer(0);
                        time++;
                    }
                }
            }
        }

        return time + bridge_length;
    }
}
