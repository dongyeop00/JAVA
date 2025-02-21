package Baekjoon.Simulation;

public class 기사단원의무기_약수찾기 {
    public static void main(String[] args) {
        int number = 5;
        int limit = 3;
        int power = 2;

        solution(number, limit, power);
    }

    private static void solution(int number, int limit, int power){
        int answer = 0;

        for(int i=1; i<= number; i++){
            int divisorCount = getDivisorCount(i);

            if(divisorCount > limit){
                answer += power;
            }else{
                answer += divisorCount;
            }
        }

        System.out.println(answer);
    }

    private static int getDivisorCount(int num){
        int count = 0;

        for(int i=1; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                count++;
                if( i != num / i){
                    count++;
                }
            }
        }

        return count;
    }
}
