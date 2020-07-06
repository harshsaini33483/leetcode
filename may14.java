package code;

import java.util.HashMap;
import java.util.Scanner;


public class may14 {
    
    static  TrieNode root;

    public static void main(String[] args) {
        root = new TrieNode();
        Scanner sc=new Scanner(System.in);
        may14 obj = new may14();
        for(int j=0;j<6;j++){
            char t =sc.next().charAt(0);
            sc.skip("\n");
            switch (t){
                case 'i':
                    System.out.println("1");
                    obj.insertWord(sc.nextLine());
                    break;
                case 's':
                    System.out.println("2");
                    System.out.println( obj.searchWord(sc.nextLine()));
                   
                    break;
                case 'p':
                    System.out.println("3");
                    System.out.println(obj.searchPrefix(sc.nextLine()));
                    
            }
        }
    }
    
    private boolean searchWord(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            if(current.children.containsKey(word.charAt(i))){
                current=current.children.get(word.charAt(i));
                if(i==word.length()-1){
                    return current.isEnded;
                }

            }else{
                return false;
            }
        }
        return false;
    }
    private boolean searchPrefix(String word){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            if(current.children.containsKey(word.charAt(i))){
                current=current.children.get(word.charAt(i));
            }else{
                return false;
            }
        }
        return true;
    }

    public void insertWord(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            TrieNode tempNode =new TrieNode();
            if(current.children.containsKey(word.charAt(i))){
                current= current.children.get(word.charAt(i));
            }else{
                current.children.put(word.charAt(i),tempNode);
                current = current.children.get(word.charAt(i));
            }
            if(i==word.length()-1){
                current.isEnded=true;
            }
        }

    }
}
 class TrieNode{
    HashMap<Character, TrieNode> children =new HashMap<>();
    boolean isEnded = false;
}