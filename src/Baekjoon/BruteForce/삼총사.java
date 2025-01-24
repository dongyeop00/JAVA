package Baekjoon.BruteForce;

public class 삼총사 {
    public static void main(String[] args) {
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        solution(number);
    }

    private static void solution(int[] number){
        int answer = 0;
        int sum = 0;

        for(int i=0; i<number.length-2; i++){
            for(int j=i+1; j<number.length-1; j++){
                for(int k=j+1; k<number.length; k++){
                    sum += number[i] + number[j] + number[k];

                    if(sum == 0){
                        answer++;
                    }
                    sum = 0;
                }
            }
        }

        System.out.println(answer);
    }
}
