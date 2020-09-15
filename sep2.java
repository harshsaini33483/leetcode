package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class sep2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums[]=new int[sc.nextInt()];
        for(int i=0;i<nums.length;i++){
            nums[i]=sc.nextInt();
        }
        int n =sc.nextInt();
        int k =sc.nextInt();
        System.out.println(containsNearbyAlmostDuplicate(nums, n, k));
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer,Integer> hsMap =new TreeMap<Integer,Integer>();
        Set<Integer> se= new HashSet<>();
        for(int i=0;i<nums.length;i++){
          hsMap.put(i, nums[i]);
          se.add(nums[i]);
        }
        int lastElement =-1,lastIndex=-1;

        for(Map.Entry<Integer, Integer> tempMap : hsMap.entrySet()){
            if(lastIndex==-1){
                lastIndex=tempMap.getKey();
                lastElement = tempMap.getValue();
            }else{
                if(Math.abs(tempMap.getValue()-lastElement)<=t){
                    return true;
                }
            }
        }
        return true;
    }
}
