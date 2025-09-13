package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 톱니바퀴 {

    static int[][] magnet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        magnet = new int[4][8];

        for(int i=0; i<4; i++){
            String str = br.readLine();
            for(int j=0; j<8; j++){
                char temp = str.charAt(j);
                magnet[i][j] = temp - '0';
            }
        }

        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            checkDir(num, dir);
        }

        System.out.println(Count());
    }

    public static void checkDir(int num, int dir){
        int index = num -1;
        int[] direction = new int[4];
        direction[index] = dir;

        // 왼쪽 탐색
        for(int i=index-1; i>=0; i--){
            if(magnet[i][2] != magnet[i+1][6]){
                direction[i] = -direction[i+1];
            }else{
                break;
            }
        }

        // 오른쪽 탐색
        for(int i=index+1; i<4; i++){
            if(magnet[i][6] != magnet[i-1][2]){
                direction[i] = -direction[i-1];
            }else{
                break;
            }
        }

        for(int i=0; i<4; i++){
            if(direction[i] != 0){
                spin(i, direction[i]);
            }
        }
    }

    public static void spin(int i, int dir) {
        if (dir == 1){
            int temp = magnet[i][7];
            for(int j=6; j>=0; j--){
                magnet[i][j+1] = magnet[i][j];
            }
            magnet[i][0] = temp;
        }else{
            int temp = magnet[i][0];
            for(int j=1; j<8; j++){
                magnet[i][j-1] = magnet[i][j];
            }
            magnet[i][7] = temp;
        }
    }

    public static int Count(){
        int count = 0;
        for(int i=0; i<4; i++){
            if(magnet[i][0] == 0) count += 0;
            else if(i==0 && magnet[i][0] == 1) count += 1;
            else if(i==1 && magnet[i][0] == 1) count += 2;
            else if(i==2 && magnet[i][0] == 1) count += 4;
            else if(i==3 && magnet[i][0] == 1) count += 8;
        }

        return count;
    }
}
