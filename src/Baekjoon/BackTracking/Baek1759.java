package Baekjoon.BackTracking;
/*
 * 최소 1개의 모음(a, e, i, o, u)과 2개의 자음
 * 알파벳이 증가하는 순서로 배열 (abcde...)
 */

import java.io.*;
import java.util.*;

public class Baek1759 {

    static int L, C;
    static char[] list;
    static char[] answer;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        L = Integer.parseInt(stringTokenizer.nextToken()); //4
        C = Integer.parseInt(stringTokenizer.nextToken()); //6
        list = new char[C];
        answer = new char[L];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < C; i++) {
            list[i] = stringTokenizer.nextToken().charAt(0);
        }

        Arrays.sort(list);

        select(0, 0);
    }

    public static void select(int depth, int index) {

        if(depth == L){
            if(checkWord()){
                System.out.println(String.valueOf(answer));
            }
            return;
        }

        for(int i=index; i<C; i++){
            answer[depth] = list[i];
            select(depth+1, i+1);
        }
    }

    public static boolean checkWord(){
        int v = 0, c = 0;

        for(int i=0; i<L; i++){
            if(answer[i] == 'a' || answer[i] == 'e' || answer[i] == 'i' || answer[i] == 'o' || answer[i] == 'u'){
                v++;
            }else{
                c++;
            }
        }

        if(v>=1 && c>=2){
            return true;
        }else{
            return false;
        }
    }

}
