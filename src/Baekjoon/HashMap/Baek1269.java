package Baekjoon.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1269 {

    public static void main(String[] arg) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        HashMap<Integer, Boolean> aMap = new HashMap<>();
        HashMap<Integer, Boolean> bMap = new HashMap<>();

        for(int i=0; i<A; i++){
            int temp = Integer.parseInt(st.nextToken());
            aMap.put(temp, true);
        }

        st = new StringTokenizer(bf.readLine());

        for(int i=0; i<B; i++){
            int temp = Integer.parseInt(st.nextToken());
            bMap.put(temp,true);
        }

        int sum = AB(aMap, bMap) + BA(aMap, bMap);

        System.out.println(sum);
    }

    private static int AB(HashMap<Integer, Boolean> aMap, HashMap<Integer, Boolean> bMap){

        HashMap<Integer, Boolean> temp = new HashMap<>(aMap);

        for(Integer key : bMap.keySet()){
            temp.remove(key);
        }

        return temp.size();
    }

    private static int BA(HashMap<Integer, Boolean> aMap, HashMap<Integer, Boolean> bMap){

        HashMap<Integer, Boolean> temp = new HashMap<>(bMap);

        for(Integer key : aMap.keySet()){
            temp.remove(key);
        }

        return temp.size();
    }

    /*
    public static void main(String[] arg) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        for(int i=0; i<A; i++){
            int temp = Integer.parseInt(st.nextToken());
            aList.add(temp);
        }

        st = new StringTokenizer(bf.readLine());

        for(int i=0; i<B; i++){
            int temp = Integer.parseInt(st.nextToken());
            bList.add(temp);
        }

        int sum = AB(aList, bList) + BA(aList, bList);

        System.out.println(sum);
    }

    private static int AB(List<Integer> aList, List<Integer> bList){
        int count = 0;

        for(int i=0; i<aList.size(); i++){
            for(int j=0; j<bList.size(); j++){
                if(Objects.equals(aList.get(i), bList.get(j))){
                    count++;
                }
            }
        }
        return aList.size() - count;
    }

    private static int BA(List<Integer> aList, List<Integer> bList){
        int count = 0;

        for(int i=0; i<bList.size(); i++){
            for(int j=0; j<aList.size(); j++){
                if(Objects.equals(bList.get(i), aList.get(j))){
                    count++;
                }
            }
        }
        return bList.size() - count;
    }

     */
}
