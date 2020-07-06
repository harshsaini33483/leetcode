package code;

import java.util.HashMap;
import java.util.Scanner;

 class may5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        HashMap<Integer,Integer> hm =new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(nums[i])){
                int num = hm.get(nums[i]);
                hm.put(nums[i],++num);
            }else{
                hm.put(nums[i],1);
            }
        }
        int max =0;
        int value = 0;
        for (HashMap.Entry<Integer,Integer> entry : hm.entrySet()) {
            if(entry.getValue()>n/2){
                if(max<entry.getValue()){
                    value = entry.getKey();
                    max= entry.getValue();
                }
            }
        }
        System.out.println(value);
    }
}