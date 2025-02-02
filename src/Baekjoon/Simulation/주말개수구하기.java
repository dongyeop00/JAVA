package Baekjoon.Simulation;

public class 주말개수구하기 {
    public static void main(String[] args) {
        int x = 7;
        System.out.println(solution(x));
    }

    private static int solution(int x){
        int count = 0;

        for(int i=0; i<365; i++){
            int currentDay = (x + i - 1) % 7 + 1;
            if(currentDay==6 || currentDay==7){
                count++;
            }
        }

        return count;
    }
}
