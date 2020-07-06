package code;

import java.util.*;
 class Solution {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        ArrayList<Integer> arr=new ArrayList<>();
        char a[] = new char[]{'h','e'};

        for(int i=p;i<=q;i++){
           long temp = (long)i*i;
           String tempStr = Long.toString(temp);
           String frStr = tempStr.substring(0,(tempStr.length()/2));
           String seStr =tempStr.substring((tempStr.length()/2));
           long first=0;
           if(!frStr.equals("")){
            first=Long.parseLong(frStr);
           }
           long second=0;
           if(!seStr.equals("")){
            second=Long.parseLong(seStr);
           }
           if(first+second==i){
            System.out.println(i);

               arr.add(i);
           }
        }
        if(arr.size()==0){
            System.out.println(" INVALID RANGE");
        }

        else{
            for(int i:arr){
                System.out.print(i+" ");
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
