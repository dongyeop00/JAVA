package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자배열회전_D2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int T = Integer.parseInt(bufferedReader.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(bufferedReader.readLine());
            int[][] map = new int[N][N];

            for(int i=0; i<N; i++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            int[][] rotation90 = method(map, N);
            int[][] rotation180 = method(rotation90, N);
            int[][] rotation270 = method(rotation180, N);

            System.out.println("#" + test_case);
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.print(rotation90[i][j]);
                }

                System.out.print(" ");

                for(int j=0; j<N; j++){
                    System.out.print(rotation180[i][j]);
                }

                System.out.print(" ");

                for(int j=0; j<N; j++){
                    System.out.print(rotation270[i][j]);
                }

                System.out.println();
            }
        }
    }

    private static int[][] method(int[][] map, int size){
        int[][] result = new int[size][size];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                result[i][j] = map[size-1-j][i];
            }
        }


        return result;
    }
}
