import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class aug30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int A[]=new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        pancakeSort(A);
    }
    public static List<Integer> pancakeSort(int[] A) {
        boolean ok =true;
        for(int i=0;i<A.length;i++){
            if(A[i]!=i+1){
                ok=false;
                break;
            }
        }
        if(ok){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int lastElement = 1;
        for(int i=A.length-1;i>=0;i--){
            if(lastElement == A[i]){
                ++lastElement;
                continue;
            }
            int traveIndex =i;
            while(traveIndex>=0 && A[traveIndex]!=lastElement){
                --traveIndex;
            }
            if(traveIndex==0){
                ans.add(i+1);
                traveIndex=i;
            }else{
                ans.add(traveIndex+1);
                A = reverseArray(traveIndex, A);
                ans.add(i+1);
            }
            ++lastElement;
           A= reverseArray(i, A);
        }
        ans.add(A.length);
        return ans;
    }

    public static int[] reverseArray(int index , int A[]){
        int newArray[]=new int[index+1];
        for(int i=index;i>=0;i--){
            newArray[i]=A[index-i];
        }
        for(int i=0;i<=index;i++){
            A[i]=newArray[i];
        }
        return A;
    }
}

3 2 4 1
2 3 4 1
4 3 2 1


2 3 4