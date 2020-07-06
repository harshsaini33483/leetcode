package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class july3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int array[] = new int[8];
        for (int i = 0; i < 8; i++) {
            array[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        prisonAfterNDays(array, n);
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {

        HashMap<String, Integer> hsMap = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            String str = Arrays.toString(cells);
            if (hsMap.containsKey(str)) {
                int days = i - hsMap.get(str);
                int remain = (N - i) % days;
                return prisonAfterNDays(cells, remain);
            } else {
                hsMap.put(str, i);
                int prev = cells[0];
                for (int j = 1; j < 7; ++j) {
                    int next = cells[j + 1];
                    int curr = cells[j];
                    cells[j] = 1 - (prev ^ next);
                    prev = curr;
                }

            }
            cells[0] = 0;
            cells[7] = 0;
        }
        return cells;
    }
}