package code;

import java.util.Scanner;

public class aug19 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String S = sc.nextLine();
        System.out.println(toGoatLatin(S));
    }
    public static String toGoatLatin(String S) {
        if(S.length()==0){
            return S;
        }
        String splitToken[] = S.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<splitToken.length;i++){
            char firstChar = Character.toLowerCase(splitToken[i].charAt(0));
            StringBuilder tempString = new StringBuilder(splitToken[i]);
            if(firstChar=='a' || firstChar=='e' || firstChar=='i' || firstChar=='o' || firstChar=='u'){
               
            }else{
                tempString.append(tempString.charAt(0));
                tempString.deleteCharAt(0);
            }
            tempString.append("ma");
            String a ="";
            for(int j=0;j<=i;j++){
                a+="a";
            }
            tempString.append(a);
            ans.append(tempString.append(" "));

        }

        return ans.deleteCharAt(ans.length()-1).toString();
    }
}