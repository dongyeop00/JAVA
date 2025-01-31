package Baekjoon.Simulation;

import java.io.IOException;
import java.util.Scanner;

public class Baek2578 {

    static int[][] map = new int[5][5];
    static int[] call = new int[25];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                map[i][j] = scanner.nextInt();
            }
        }

        for(int i=0; i<25; i++){
            call[i] = scanner.nextInt();
        }

        scanner.close();

        for(int i=0; i<25; i++){
            int num = call[i];
            removeNumber(num);

            if(checkBingo() == 3){
                System.out.println(i+1);
                return;
            }
        }

    }

    private static void removeNumber(int num){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(num == map[i][j]){
                    map[i][j] = 0;
                    return;
                }
            }
        }
    }

    private static int checkBingo(){
        int count = 0;

        //가로 확인
        for(int i=0; i<5; i++){
            if(map[i][0]==0 && map[i][1]==0 && map[i][2]==0 && map[i][3]==0 && map[i][4]==0){
                count++;
            }
        }

        //세로 확인
        for(int i=0; i<5; i++){
            if(map[0][i]==0 && map[1][i]==0 && map[2][i]==0 && map[3][i]==0 && map[4][i]==0){
                count++;
            }
        }

        //대각선 확인
        if(map[0][0] == 0 && map[1][1] == 0 && map[2][2] == 0 && map[3][3] == 0 && map[4][4] == 0){
            count++;
        }

        //대각선 확인
        if(map[0][4] == 0 && map[1][3]==0 && map[2][2] == 0 && map[3][1] == 0 && map[4][0]==0){
            count++;
        }

        return count;
    }
}
