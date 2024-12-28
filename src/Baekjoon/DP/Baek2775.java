package Baekjoon.DP;

import java.util.Scanner;

/* 부녀회장이 될테야
평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.

이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.

아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라.
단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.

2
1
3
2
3

6
10
 */

public class Baek2775 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for(int i=0; i<testCase; i++){
            int k = scanner.nextInt(); //층
            int n = scanner.nextInt(); //호

            int[][] apt = new int[k+1][n+1];

            for(int j=0; j<=n; j++){
                apt[0][j] = j;
            }

            // apt[1][3] = apt[0][0] + apt[0][1] + apt[0][2] + apt[0][3]
            //           = apt[1][2] + apt[0][3]
            for(int a=1; a<=k; a++){
                for(int b=1; b<=n; b++){
                    apt[a][b] = apt[a][b-1] + apt[a-1][b];
                }
            }

            System.out.println(apt[k][n]);
        }
    }
}
