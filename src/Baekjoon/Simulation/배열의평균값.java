package Baekjoon.Simulation;

public class 배열의평균값 {
    public static void main(String[] args) {
        int[] numbers = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
        solution(numbers);
    }

    private static void solution(int[] numbers){
        double answer = 0;

        for(int i=0; i< numbers.length; i++){
            answer += numbers[i];
        }

        System.out.println(answer / numbers.length);
    }
}
