package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class may22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(frequencySort(str));

    }

    public static String frequencySort(String s) {
        int capitalA[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            ++capitalA[(int)s.charAt(i)];
        }
        ArrayList<CharacterFreq> arr = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            if (capitalA[i] != 0) {
                CharacterFreq temp1 = new CharacterFreq();
                temp1.c = (char)(i);
                temp1.freq = capitalA[i];
                arr.add(temp1);
            }
           
        }
        Collections.sort(arr, new CharaterterSort());
        String str = "";
        for (CharacterFreq charseq : arr) {
            int frequ = charseq.freq;
            for (int i = 0; i < frequ; i++) {
                str += charseq.c + "";
            }
        }
        return str;
    }
}

class CharacterFreq {
    int freq;
    char c;
}

class CharaterterSort implements Comparator<CharacterFreq> {
    public int compare(CharacterFreq a, CharacterFreq b) {
        return b.freq - a.freq;
    }
}