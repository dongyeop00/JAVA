package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 프린터큐 {

    private static class Document{
        int index;
        int priority;

        Document(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int testCase = Integer.parseInt(stringTokenizer.nextToken());

        for(int i=0; i<testCase; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken()); // 문서의 개수
            int M = Integer.parseInt(stringTokenizer.nextToken()); // M번째 문서가 몇번째로 출력되는지

            LinkedList<Document> queue = new LinkedList<>();

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            //[값, 중요도]
            for(int a=0; a<N; a++){
                queue.offer(new Document(a, Integer.parseInt(stringTokenizer.nextToken())));
            }

            int printOrder = 0;

            while(!queue.isEmpty()){
                Document current = queue.poll();
                boolean hasHigh = false;

                //현재 문서보다 높은 우선순위가 있는지 확인
                for(Document doc : queue){
                    if(doc.priority > current.priority){
                        hasHigh = true;
                        break;
                    }
                }

                //현재 문서보다 높은 우선순위가 있으면
                if(hasHigh){
                    queue.add(current);
                }
                //현재 문서보다 높은 우선순위가 없으면
                else{
                    printOrder++;
                    if(current.index == M){
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }
    }
}
