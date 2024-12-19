package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 크로아티아 알파벳
예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.

  크로아티아 알파벳	변경
        č	        c=
        ć	        c-
        dž	        dz=
        đ	        d-
        lj	        lj
        nj	        nj
        š	        s=
        ž	        z=

예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다.
단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.

dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다.
lj와 nj도 마찬가지이다.
위 목록에 없는 알파벳은 한 글자씩 센다.

 */

public class Baek2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String command = bufferedReader.readLine();

        System.out.println(Check(command));
    }

    private static int Check(String command){

        int count = 0;

        for(int i=0; i<command.length(); i++){
            char c = command.charAt(i);

            if(c == 'c'){
                if(i<command.length() - 1){
                    if(command.charAt(i+1) == '='){
                        i++;
                    }else if(command.charAt(i+1) == '-'){
                        i++;
                    }
                }
            }else if(c == 'd'){
                if(i<command.length() - 1){
                    if(command.charAt(i+1) == 'z'){
                        if(i<command.length() -2){
                            if(command.charAt(i+2) == '='){
                                i += 2;
                            }
                        }
                    }else if(command.charAt(i+1) == '-'){
                        i++;
                    }
                }
            }else if(c == 'l'){
                if(i<command.length() - 1){
                    if(command.charAt(i+1) == 'j'){
                        i++;
                    }
                }
            }else if(c == 'n'){
                if(i<command.length() - 1){
                    if(command.charAt(i+1) == 'j'){
                        i++;
                    }
                }
            }else if(c == 's'){
                if(i<command.length() - 1){
                    if(command.charAt(i+1) == '='){
                        i++;
                    }
                }
            }else if(c == 'z'){
                if(i<command.length() -1){
                    if(command.charAt(i+1) == '='){
                        i++;
                    }
                }
            }

            count++;
        }

        return count;
    }
}
