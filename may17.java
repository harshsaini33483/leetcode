package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class may17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        List<Integer> list = findAnagrams(s,p);
        for(int i:list){
            System.out.println(i+" ");
        }
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(p.length()>s.length()){
            return ans;
        }
        HashMap<Character, Integer> hm= new HashMap<>();
        int array[]=new int[26];
        for(int i=0;i<p.length();i++){
            ++array[s.charAt(i)-'a'];
            if(hm.containsKey(p.charAt(i))){
                hm.put(p.charAt(i), hm.get(p.charAt(i))+1);
            }else{
                hm.put(p.charAt(i),1);
            }
        }
        boolean ok =true;
        for(Map.Entry<Character,Integer> map : hm.entrySet()){
            char checkChar = map.getKey();
            int checkCount =map.getValue();
            if(array[checkChar-'a']!=checkCount){
                ok=false;
                break;
            }

        }
        if(ok){
            ans.add(0);
        }
        for(int i=p.length();i<s.length();i++){
            --array[s.charAt((i-p.length()))-'a'];
            ++array[s.charAt(i)-'a'];
            ok=true;
            for(Map.Entry<Character,Integer> map : hm.entrySet()){
                char checkChar = map.getKey();
                int checkCount =map.getValue();
                if(array[checkChar-'a']!=checkCount){
                    ok=false;
                    break;
                }
            }
            if(ok){
                ans.add(i-p.length()+1);
            }
        }
        
        return ans;

    }
}