package Baekjoon.Simulation;

public class 거듭제곱_D3 {

    static int num, count;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            int T = readInt();

            num = readInt();
            count = readInt();

            int result = pow(count);
            System.out.println("#" + T + " " + result);
        }
    }

    private static int pow(int count) {
        if (count == 0) return 1;
        return num * pow(count - 1);
    }

    // System.in.read()로 숫자 읽는 함수
    private static int readInt() throws Exception {
        int result = 0;
        int ch;
        boolean started = false;

        while ((ch = System.in.read()) != -1) {
            if (ch >= '0' && ch <= '9') {
                result = result * 10 + (ch - '0');
                started = true;
            } else if (started) {
                break;
            }
        }

        return result;
    }
}
