package code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class sep7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String pattern =sc.nextLine();
        String str = sc.nextLine();
        System.out.println(wordPattern(pattern, str));
    }
    public static boolean wordPattern(String pattern, String str) {
        Map<Character,String> hMap =new HashMap<>();
        Map<String,Character> sMap =new HashMap<>();

        String tokenStr [] = str.split(" ");

        if(pattern.length()!=tokenStr.length){
            return false;
        }
        for(int i=0;i<tokenStr.length;i++){
            if(hMap.containsKey(pattern.charAt(i))){
                if(!hMap.get(pattern.charAt(i)).equals(tokenStr[i])){
                    return false;
                }
            }else if(sMap.containsKey(tokenStr[i])){
                if(sMap.get(tokenStr[i])!=pattern.charAt(i)){return false;}
            }
            else{
                hMap.put(pattern.charAt(i),tokenStr[i]);
                sMap.put(tokenStr[i],pattern.charAt(i));
            }
        }
        return true;
    }
}
