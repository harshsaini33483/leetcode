package code;

public class MyHashSet {
    boolean array[];
    public MyHashSet() {
        array=new boolean[1000001];
    }
    
    public void add(int key) {
        array[key]=true;
    }
    
    public void remove(int key) {
        array[key]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(array[key]){
            return true;
        }else{
            return false;
        }
    }
}