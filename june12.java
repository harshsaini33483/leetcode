package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class june12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RandomizedSet obj =new RandomizedSet();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            switch(sc.nextInt()){
                case 1:
                    obj.insert(sc.nextInt());
                    break;
                case 2:
                    obj.remove(sc.nextInt());
                    break;
                case 3:
                    System.out.println(obj.getRandom());
            }
        }
    }

    

}
class RandomizedSet {

    /** Initialize your data structure here. */
    HashMap<Integer,Integer>hm ;
    List<Integer> list;       
    public RandomizedSet() {
        hm =new HashMap<>();
        list = new ArrayList<Integer>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
       if(!hm.containsKey(val)){
        hm.put(val,list.size());
           list.add(val);
           return true;
       }else{
           return false;
       }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if(hm.containsKey(val)){
            int index = hm.get(val);
            int size = list.size()-1;
            int lastValue = list.get(size);
            int no = list.get(index);
            hm.replace(lastValue, index);
            list.set(index, lastValue);
            list.remove(size);
            hm.remove(val);
                  
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
      Random random = new Random();
    System.out.println(list.size());
       return list.get(random.nextInt(list.size()+1));
    }
}