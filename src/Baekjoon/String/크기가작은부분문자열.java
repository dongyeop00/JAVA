package Baekjoon.String;

public class 크기가작은부분문자열 {
    public static void main(String[] args) {
        String t = "10203";
        String p = "15";

        System.out.println(solution(t,p));
    }


    private static int solution(String t, String p){
        long max = Long.parseLong(p);
        int count = 0;

        for(int i=0; i<=t.length() - p.length(); i++){
            long temp = Long.parseLong(t.substring(i,i+p.length()));
            if(max >= temp){
                count++;
            }
        }

        return count;
    }
}
