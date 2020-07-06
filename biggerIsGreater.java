package code;

import java.util.Scanner;

public class biggerIsGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(biggerIsGreater(str));

    }

    static String biggerIsGreater(String w) {
        if (w.length() == 1) {
            return "no answer";
        }
        boolean ok = false;

        StringBuilder str = new StringBuilder(w);
        int i = w.length() - 2;
        int minIndex = -1;

        for (; i >= 0; i--) {
            char currChar = str.charAt(i);
            int maxLen = -99999;

            for (int j = w.length()-1; j >i; j--) {
                int len = (int) currChar - (int) str.charAt(j);
                if (len < 0 && maxLen < len) {
                    maxLen = len;
                    minIndex = j;
                    break;
                }
            }
            if (minIndex != -1) {
                char now = str.charAt(minIndex);
                str.setCharAt(minIndex, str.charAt(i));
                str.setCharAt(i, now);
                ok = true;
                break;
            }
        }
        if (ok) {
            StringBuilder newRevString = new StringBuilder(str.substring(i + 1));
            newRevString.reverse();
            str.replace(i + 1, str.length(), newRevString.toString());
            return str.toString();
        } else {
            return "no answer";
        }

    }
}
// input jkscckttaeifiksgkmxx
// ans = jkscckttaeifiksgkxmx
//       jkscckttaeifiksgkxxm


