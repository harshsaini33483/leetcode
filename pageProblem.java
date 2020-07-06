package code;
import java.util.Scanner;

public class pageProblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int array[]=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }

        System.out.println(workbook(n,k,array));
    }
    static int workbook(int n, int k, int[] arr) {
        int page=1;
        int count=0;
        for(int i=0;i<n;i++){
            int problems =1;
            int temp =arr[i];
            while(temp>0){
                int tempPage = temp-k >= 0? k: temp;
                int pageProblem = tempPage+problems-1;
                if(problems<=page && pageProblem>=page){
                    ++count;
                }
                ++page;
                problems=pageProblem+1;
                temp-=k;
            }
        }
        return count;
    }
}