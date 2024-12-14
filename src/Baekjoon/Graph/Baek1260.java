package Baekjoon.Graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* DFS와 BFS
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
정점 번호는 1번부터 N번까지이다.
 */
public class Baek1260 {

    static int N,M,V;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int count;

    public static void main(String[] arg) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        count = 0;

        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i=0; i<N+1; i++){
            Collections.sort(graph.get(i));
        }

        // DFS 실행
        DFS(V);

        System.out.println();

        visited = new int[N+1];
        count = 0;

        BFS(V);
    }

    private static void DFS(int v){
        System.out.print(v + " ");
        count++;
        visited[v] = count;

        for(int i=0; i<graph.get(v).size(); i++){
            int node = graph.get(v).get(i);
            if(visited[node] == 0){
                DFS(node);
            }
        }
    }

    private static void BFS(int v){
        System.out.print(v + " ");

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);
        visited[v] = ++count;

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i=0; i<graph.get(node).size(); i++){
                int temp = graph.get(node).get(i);
                if(visited[temp] == 0){
                    System.out.print(temp + " ");
                   queue.offer(temp);
                   visited[temp] = ++count;
                }
            }
        }
    }
}
