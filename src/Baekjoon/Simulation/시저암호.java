package Baekjoon.Simulation;

public class 시저암호 {
    public static void main(String[] args) {
        String s = "a B z";
        int n = 4;
        solution(s,n);
    }

    private static void solution(String s, int n){
        String answer = "";

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(64 < c && c < 91){
                c += n;
                if(c > 90){
                    c -= 26;
                }
            }

            if( 96 < c && c < 123){
                c += n;
                if(c > 122){
                    c -= 26;
                }
            }

            answer += c;
        }

        System.out.println(answer);
    }
}
