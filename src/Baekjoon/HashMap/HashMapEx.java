package Baekjoon.HashMap;

import java.io.IOException;
import java.util.HashMap;

public class HashMapEx {
    public static void main(String[] arg) throws IOException {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // 초기 용량 지정
        HashMap<Integer, Integer> map3 = new HashMap<>(10);

        // 선언과 동시에 값 추가
        HashMap<String, Integer> map4 = new HashMap<>(){{
            put("banana", 5);
            put("apple", 10);
            put("bear", 6);
        }};

        // 값 삽입 put(key, value)
        map4.put("go",10);
        map4.put("house", 505);

        // 해쉬맵 출력
        System.out.println(map4); // 결과 : {banana=5, apple=10, go=10, bear=6, house=505}

        //값 삭제 remove(key)
        map4.remove("go");

        // 해쉬맵 출력
        System.out.println(map4); // 결과 : {banana=5, apple=10, bear=6, house=505}

        // 특정 key의 value값 가져오기 get(key)
        System.out.println("banana의 value값 : " + map4.get("banana"));

        // 특정 key의 value값 증가 시키기
        map4.put("banana", map4.get("banana")+5);

        // 지정된 key에 매핑된 value가 없거나 null이고, 존재하지 않은 key의 value를 가져오려할 때, defaultValue를 기본값으로하고 HashMap 생성
        map4.put("hello", map4.getOrDefault("hello",0)+1);

        System.out.println(map4);

        // 특정 키 포함 여부
        System.out.println("특정 키 포함 여부 : " + map4.containsKey("hello"));
        System.out.println("특정 키 포함 여부 : " + map4.containsKey("bye"));
        System.out.println("특정 값 포함 여부 : " + map4.containsValue(5));
        System.out.println("특정 값 포함 여부 : " + map4.containsValue(505));
    }
}
