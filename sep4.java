package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class sep4 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        List<Integer> ans  = partitionLabels(sc.nextLine());
        for(int i: ans){
            System.out.println(i);
        }
    }
    public  static List<Integer> partitionLabels(String S) {
        Map<Character, Integer> hMap = new HashMap<>();
        for(int i=0;i<S.length();i++){
            hMap.put(S.charAt(i),i);
        }
        List<Integer> ans =new ArrayList<>();
        int maxIndex = -1;
        int start =0;
        for(int i=0;i<S.length();i++){

 if(maxIndex<i){
                start=i;
                maxIndex = hMap.get(S.charAt(i));
                if(maxIndex==i){
                    ans.add((i-start)+1);
                }
            } else if(maxIndex<hMap.get(S.charAt(i)) && i<maxIndex){
                maxIndex = hMap.get(S.charAt(i));
            }

        }
        return ans;
    }
    public  static List<Integer> alternatepartitionLabels(String S) {
        int array[]=new int[26];
        int n =S.length();
        for(int i=0;i<n;i++){
            array[S.charAt(i)-'a']=i;
        }
        List<Integer> ans =new ArrayList<>();

        int maxIndex =0,index=0;
        for(int i=0;i<n;i++){
            maxIndex = Math.max(maxIndex, array[S.charAt(i)-'a']);
            if(maxIndex==i){
                ans.add((i-index)+1);
                index=i+1;
            }
        }
        return ans;
    }
}
