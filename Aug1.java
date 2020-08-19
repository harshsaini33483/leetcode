package code;

import java.util.Scanner;

public class Aug1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(detectCapitalUse(word));
    }


    public static boolean detectCapitalUse(String word) {
        if(word.length()<=0){
            return true;
        }    
        int upperCount=0;
        for(int i=0;i<word.length();i++){
            if((word.charAt(i)>='A' && word.charAt(i)<='Z')){
                if(upperCount==i){
                    ++upperCount;
                }else{
                    return false;
                }
            }
        }
        if(upperCount<=1 || word.length()==upperCount){
            return true;
        }
        return false;
    }
}