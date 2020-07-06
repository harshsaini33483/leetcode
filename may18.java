package code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class may18 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String first =sc.nextLine();
        String second = sc.nextLine();
        System.out.println(checkInclusion(first, second));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        HashMap<Character, Integer> hm =new HashMap<>();
        int array[]=new int[26];
        for(int i=0;i<s1.length();i++){
            if(hm.containsKey(s1.charAt(i))){
                hm.put(s1.charAt(i), hm.get(s1.charAt(i))+1);
            }else{
                hm.put(s1.charAt(i),1);
            }
        }
        for(int i=0;i<s1.length();i++){
            ++array[s2.charAt(i)-'a'];
            continue;
        }
        boolean ok =true;

        for(Map.Entry<Character, Integer> valueS : hm.entrySet()){
            if(array[valueS.getKey()-'a']!=valueS.getValue()){
                ok=false;
                break;
            }
        }
        if(ok){
            return true;
        }
      for(int i=s1.length();i<s2.length();i++){
            ok=true;
            --array[s2.charAt(i-s1.length())-'a'];
            ++array[s2.charAt(i)-'a'];

            for(Map.Entry<Character, Integer> valueS : hm.entrySet()){
                if(array[valueS.getKey()-'a']!=valueS.getValue()){
                    ok=false;
                    break;
                }
            }
            if(ok){
                return true;
            }
           
        }
        return false;
    }
}