package Baekjoon.Simulation;

public class 키보드 {
    public static void main(String[] args) {
        //String[] input = {"HM", "d", "e", "HM", "f", "g", "CL", "BS", "END", "a", "z_"};
        String[] input = {"a","b","c","HM", "d", "e", "END", "f", "g"};
        System.out.println(processCommands(input));
    }

    public static String processCommands(String[] commands) {
        String text = "";
        boolean capsLock = false;
        int cursor = 0;

        for (String cmd : commands) {
            switch (cmd) {
                case "BS":
                    if (cursor > 0) {
                        text = text.substring(0, cursor - 1) + text.substring(cursor);
                        cursor--;
                    }
                    break;
                case "CL":
                    capsLock = !capsLock;
                    break;
                case "HM":
                    cursor = 0;
                    break;
                case "END":
                    cursor = text.length();
                    break;
                default:
                    char ch;
                    if (cmd.length() == 2 && cmd.charAt(1) == '_') {
                        ch = cmd.charAt(0);
                        ch = Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
                    } else {
                        ch = cmd.charAt(0);
                        if (capsLock) {
                            ch = Character.toUpperCase(ch);
                        }
                    }
                    text = text.substring(0, cursor) + ch + text.substring(cursor);
                    cursor++;
                    break;
            }
        }
        return text;
    }
}


