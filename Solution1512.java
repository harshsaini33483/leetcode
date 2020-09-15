package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution1512 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nums[]=new int[sc.nextInt()];
        for(int i=0;i<nums.length;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(numIdenticalPairs(nums));
    }
    public static int numIdenticalPairs(int[] nums) {
        int ans=0;
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             ++ans;
        //         }
        //     }
        // }
 
        HashMap<Integer,Integer>hs =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hs.containsKey(nums[i])){
                int currentCount=hs.get(nums[i]);
                hs.put(nums[i], currentCount+1);
                ans+=currentCount;
            }else{
                hs.put(nums[i], 1);
            }
        }
        return ans;
    }
}
