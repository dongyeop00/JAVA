package Baekjoon.String;

public class 숫자문자열과영단어 {
    public static void main(String[] args) {
        String s = "one4seveneight";

        solution(s);
    }

    private static void solution(String s){
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<10; i++){
            s = s.replace(num[i], Integer.toString(i));
        }

        int answer = Integer.parseInt(s);

        System.out.println(answer);
    }
}
