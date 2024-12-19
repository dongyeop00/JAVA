package Baekjoon.Graph.DFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 촌수 계산
우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다.
이러한 촌수는 다음과 같은 방식으로 계산된다. 기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다.
예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
 */
public class Baek2644 {

    static int n, a, b, m,count;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        n = Integer.parseInt(bufferedReader.readLine());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        a = Integer.parseInt(stringTokenizer.nextToken());
        b = Integer.parseInt(stringTokenizer.nextToken());

        m = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        count = -1;

        for(int i=0; i<m; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        DFS(a,b,0);
        System.out.println(count);
    }

    private static void DFS(int x, int y, int depth){
        if(!visited[x]){
            visited[x] = true;
        }

        if(x == y){
            count = depth;
            return;
        }

        for(int i=0; i<graph.get(x).size(); i++){
            int node = graph.get(x).get(i);

            if(!visited[node]){
                DFS(node,y,depth+1);
            }
        }

    }
}
