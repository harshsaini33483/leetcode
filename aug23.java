package code;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class aug23 {
    static Tries trie = new Tries();
   static Deque<Character> queue = new LinkedList<>();
        
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        sc.skip("\n");
        String words[] =new String[n];
        for(int i=0;i<n;i++){
            words[i]=sc.nextLine();
        }
        buildTries(words);
        while(true){
            query(sc.next().charAt(0));
           
        }
    }   

    public static void buildTries(String []words){
        
        for(String word: words){
            Tries dummyNode = trie;
            char []ch = word.toCharArray();
            for(int i = ch.length-1;i>=0;i--){
                if(!dummyNode.trieNode.containsKey(ch[i])){
                    dummyNode.trieNode.put(ch[i], new Tries());
                }
                dummyNode= dummyNode.trieNode.get(ch[i]);
                if(i==0){
                    dummyNode.wordEnd = true;
                }
                
            }
        }
    }
    public static boolean query(char letter){
        boolean ans = false;
        Tries tempTrie = trie;
        queue.addFirst(letter);
        for(char c:queue){
            if(tempTrie.trieNode.containsKey(c)){
                tempTrie = tempTrie.trieNode.get(c);
                if(tempTrie.wordEnd){
                   return true;
                }
            }else{
                return false;
            }
               
        }
        return ans;
    }
}
class Tries{
    boolean wordEnd ;
    HashMap<Character, Tries> trieNode = new HashMap<>();
}

// ["StreamChecker","query","query","query","query","query","query","query","query","query","query","query","query"]
// [[["cd","f","kl"]],["a"],["b"],["c"],["d"],["e"],["f"],["g"],["h"],["i"],["j"],["k"],["l"]]