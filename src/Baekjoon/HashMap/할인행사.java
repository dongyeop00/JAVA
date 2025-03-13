package Baekjoon.HashMap;

import java.util.HashMap;

public class 할인행사 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3,2,2,2,1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        solution(want, number, discount);
    }

    private static void solution(String[] want, int[] number, String[] discount){
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length-10; i++) {
            HashMap<String, Integer> checkMap = new HashMap<>(map);

            for (int j = i; j < i+10; j++) {
                String str = discount[j];
                if(checkMap.containsKey(str)){
                    checkMap.put(str, checkMap.get(str)-1);
                }
            }

            boolean allZero = true;
            for(Integer value : checkMap.values()){
                if(value > 0){
                    allZero = false;
                    break;
                }
            }

            if(allZero){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
