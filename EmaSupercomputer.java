package code;

import java.util.Arrays;
import java.util.Scanner;

public class EmaSupercomputer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.skip("\n");
        String str[] = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.nextLine();
        }
        twoPluses(str);
    }

    static int twoPluses(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();
        int arr[][] = new int[grid.length][grid[0].length()];
        for (int i = 0; i < row; i++) {
            Arrays.fill(arr[i], 0);
        }
        int max1 = 0, maxI = -1, maxJ = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i].charAt(j) == 'G') {
                    int top = i - 1;
                    int bottom = i + 1;
                    int left = j - 1;
                    int right = j + 1;
                    int count = 1;
                    arr[i][j] = arr[i][j] + 1;
                    while ((top >= 0 && bottom < row && left >= 0 && right < col) && (grid[top].charAt(j)=='G'
                     && grid[bottom].charAt(j)=='G' && grid[i].charAt(left)=='G' && grid[i].charAt(right)=='G') ) {
                        count += 4;
                        arr[top][j] += 1;
                        arr[bottom][j] += 1;
                        arr[i][left] += 1;
                        arr[i][right] += 1;
                        top = top - 1;
                        bottom = bottom + 1;
                        left = left - 1;
                        right = right + 1;
                    }
                    if (max1 < count) {
                        max1 = count;
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        if (maxI == -1 && maxJ == -1) {
            return 0;
        }
        int topDis = maxI - 1;
        int bottomDis = maxI + 1;
        int left = maxJ - 1;
        int right = maxJ + 1;
        arr[maxI][maxJ]=0;
        // 1 1 1 1 1 1 
        // 1 0 0 0 2 0 
        // 1 1 1 2 1 2 
        // 1 1 0 0 2 0 
        // 1 1 1 1 1 1 
        while (topDis >= 0 && bottomDis < row && left >= 0 && right < col) {
            arr[topDis][maxJ] = 0;
            arr[bottomDis][maxJ] = 0;
            arr[maxI][left] = 0;
            arr[maxI][right] = 0;
            --topDis;
            ++bottomDis;
            --left;
            ++right;
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        // 0 0 0 0 2 0 
        // 0 0 0 2 1 2 
        // 0 0 0 0 3 0 
        // 2 1 2 2 1 2 
        // 0 2 0 0 2 0 
        // 0 1 0 0 1 0        
        int max2=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j]>=1) {
                    int top = i - 1;
                    int bottom = i + 1;
                     left = j - 1;
                     right = j + 1;
                    int count = 1;
                    arr[i][j] = arr[i][j] + 1;
                    while ((top >= 0 && bottom < row && left >= 0 && right < col) && (arr[top][j]>=1
                     && arr[bottom][j]>=1 && arr[i][left]>=1 && arr[i][right]>=1) ) {
                        count += 4;
                        top = top - 1;
                        bottom = bottom + 1;
                        left = left - 1;
                        right = right + 1;
                    }
                    if (max2 < count) {
                        max2 = count;
                    }
                }
            }
        }
      
        return max1*max2;
    }
}