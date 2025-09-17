package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계란으로계란치기 {

    static int N, max;
    static Egg[] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        max = 0;
        eggs = new Egg[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int hp = Integer.parseInt(st.nextToken());
            int power = Integer.parseInt(st.nextToken());

            eggs[i] = new Egg(hp, power);
        }

        // 가장 맨 왼쪽의 계란을 든다.
        backTracking(0);
        System.out.println(max);
    }

    /**
     *
     * @param index : 현재 들고 있는 계란의 위치
     */
    /*
        1. 가장 왼쪽의 계란을 든다.
        2. 손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다.
            2.1 손에 든 계란이 깨져있으면 넘어간다.
            2.2 깨지지 않은 계란이 없으면 치지 않고 넘어간다.
        3. 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 진행

     */
    public static void backTracking(int index){
        if(index == N){
            max = Math.max(max, count());
            return;
        }

        // 2.1 조건 손에 든 계란이 이미 깨져있다면 넘김
        if(eggs[index].hp <= 0){
            backTracking(index+1); // 다음 칸으로 재귀 넘기고
            return; // 현재 재귀는 종료
        }

        boolean canhitSome = false;
        // 부딪힐 계란
        for(int i=0; i<N; i++){
            // 자기 자신이면 넘김
            if(i == index) continue;
            // 이미 깨져 있으면 넘김
            if(eggs[i].hp <= 0) continue;

            canhitSome = true;

            eggs[index].hp -= eggs[i].power;
            eggs[i].hp -= eggs[index].power;

            backTracking(index + 1);

            eggs[index].hp += eggs[i].power;
            eggs[i].hp += eggs[index].power;
        }

        // 2.2 조건 깨지지 않은 계란이 없으면 치지 않고 넘어간다.
        if(!canhitSome){
            backTracking(index+1);
        }
    }

    public static int count(){
        int count = 0;
        for(int i=0; i<N; i++) {
            if (eggs[i].hp <= 0) {
                count++;
            }
        }
        return count;
    }

    public static class Egg{
        int hp;
        int power;

        Egg(int hp, int power){
            this.hp = hp;
            this.power = power;
        }
    }
}
