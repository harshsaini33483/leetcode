package code;

import java.util.Scanner;

public class sep10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String secret = sc.nextLine();
        String guess = sc.nextLine();
        System.out.println(getHint(secret, guess));
    }
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int arr[]=new int[10];
        boolean point[]=new boolean[secret.length()];
        for(int i=0;i<secret.length();i++){
            ++arr[secret.charAt(i)-'0'];
        }
        for(int i=0;i<secret.length();i++){ 
            if(secret.charAt(i)==guess.charAt(i)){
                ++bulls;
                point[i]=true;
              --arr[secret.charAt(i)-'0'];
            }
        }
        int b= 0;
        for(int i=0;i<guess.length();i++){
            if(arr[guess.charAt(i)-'0']>0 && !point[i]){
                ++b;
                --arr[guess.charAt(i)-'0'];
            }
        }
       
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append("A").append(b).append("B");
        return sb.toString();
    }
}
