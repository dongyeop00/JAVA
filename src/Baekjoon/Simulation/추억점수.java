package Baekjoon.Simulation;

import java.util.ArrayList;
import java.util.List;

public class 추억점수 {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}};

        solution(name, yearning, photo);
    }

    private static void solution(String[] name, int[] yearning, String[][] photo){
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<photo.length; i++){
            int sum = 0;
            for(int j=0; j<photo[i].length; j++){
                for(int k=0; k<name.length; k++){
                    if(photo[i][j].equals(name[k])){
                        sum += yearning[k];
                    }
                }
            }
            list.add(sum);
        }

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
