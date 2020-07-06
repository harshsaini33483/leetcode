package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class june13 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length==0){
            return new ArrayList<Integer>();
        }
        Arrays.sort(nums);
        int  diff[] = new int[nums.length];
        int  prev[] = new int[nums.length];
        Arrays.fill(diff,1);
        Arrays.fill(prev,-1);
        int index=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(diff[i]<diff[j]+1){
                        diff[i]=diff[j]+1;
                        prev[i]=j;
                    }
                }
            }
            
      if(diff[index]<diff[i]){
          index=i;
        }
    }
        ArrayList<Integer> arr =new ArrayList<Integer>();
       int k=index;
        while(k>=0){
            arr.add(nums[k]);
            k = prev[k];
        }
        return arr;
    }
}