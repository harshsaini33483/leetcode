package code;

import java.util.Arrays;
import java.util.Scanner;

public class may25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int A[] = new int[n];
        int B[] = new int[m];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }
        System.out.println(maxUncrossedLines(A, B));
    }

    public static int maxUncrossedLines(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int LCA[][]=new int[lenB+1][lenA+1];
        for(int i=1;i<=lenB;i++){
            for(int j=1;j<=lenA;j++){
                if(B[i-1]==A[j-1]){
                    LCA[i][j]=LCA[i-1][j-1]+1;
                }else{
                    LCA[i][j]=Math.max(LCA[i][j-1],LCA[i-1][j]);
                }
            }
        }
        return LCA[lenB][lenA];
    }

}
// [1,1,2,1,2]
// [1,3,2,3,1]