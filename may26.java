package code;

import java.util.HashMap;
import java.util.Scanner;

public class may26 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(findMaxLength(nums));
    }
    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm =new HashMap<>();
        int count=0;
        int lengthMax= 0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                --count;
            }else{
                ++count;
            }
            if(hm.containsKey(count)){
                lengthMax = Math.max(lengthMax, i-hm.get(count));
            }else{
                hm.put(count, i);
            }
        }
        
        return lengthMax;
    }
}