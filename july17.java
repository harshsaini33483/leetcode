package code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class july17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int k =sc.nextInt();
        int array[]=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        topKFrequent(array, k);
    }
    public static int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> tree =new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(tree.containsKey(nums[i])){
                tree.put(nums[i], tree.get(nums[i])+1);
            }else{
                tree.put(nums[i],1);
            }
        }
        HeapMap preCompute[]=new HeapMap[tree.size()];
        int i=0;
        for(Map.Entry<Integer,Integer> map: tree.entrySet()){
            preCompute[i]=new HeapMap(map.getKey(), map.getValue());
            ++i;
        }
        int ans []=new int[k];
        Arrays.sort(preCompute, new Comparator<HeapMap>(){
            public int compare(HeapMap a, HeapMap b){
                return b.frequency-a.frequency;
            }
        });
        for(i=0;i<k;i++){
            ans[i]=preCompute[i].index;
        }
        return ans;
    }

}
class HeapMap{
    int index,frequency;
    public HeapMap(int index, int frequency){
        this.index=index;
        this.frequency= frequency;

    }
}