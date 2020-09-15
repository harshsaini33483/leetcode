package code;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class sep1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A[]=new int[4];
        A[0]=sc.nextInt();
        A[1]=sc.nextInt();
        A[2]=sc.nextInt();
        A[3]=sc.nextInt();
        System.out.println( largestTimeFromDigits(A));
       
    }
    public static String largestTimeFromDigits(int[] A) {
        boolean ok =false;
        int sum=0;
        for(int i=0;i<A.length;i++){
            if(A[i]<=2){
                ok=true;
            }
            sum+=A[i];
        }
        if(!ok || sum>19){
            return "";
        }
        
        String ans="";
        int index =-1;
        for(int i=0;i<A.length;i++){
         if(A[i]<=2 ){
            if(index!=-1 && A[index]>A[i]){
                index=i;
            }else{
                index=i;
            }
         }   
        }
        ans+=A[index];
        index= A[index];
        A[index]=-1;

        int secondElement =-1,secondIndex=-1;
        for(int i=0;i<A.length;i++){
            if(index!=2){
                if(secondElement<A[i]){
                    secondElement= A[i];
                    secondIndex=i;
                }
            }else if(secondElement<A[i] && secondElement>=3){
                secondIndex=i;
                secondElement=A[i];
            }
        }
        ans+=secondElement;
        A[secondIndex]=-1;

        int thirdElement =-1,thirdIndex=-1;
        for(int i=0;i<A.length;i++){
            if(index!=2){
                if(secondElement<A[i]){
                    secondElement= A[i];
                    secondIndex=i;
                }
            }else if(secondElement<A[i] && secondElement>=5 ){
                secondIndex=i;
                secondElement=A[i];
            }
        }
        return ans;
    }
}