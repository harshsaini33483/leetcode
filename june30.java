package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class june30 {
    static HashSet<String> hSet =new HashSet<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        char puzzle[][]=new char[n][n];
        sc.skip("\n");
        for(int i=0;i<puzzle.length;i++){
            puzzle[i]=sc.nextLine().toCharArray();
        }
        String words[]=new String[sc.nextInt()];
        sc.skip("\n");
        for(int i=0;i<words.length;i++){
            words[i]=sc.nextLine();
        }
        findWords(puzzle, words);
        for(String str: hSet){
            System.out.println(str);
        }
    }
      public static List<String> findWords(char[][] board, String[] words) {
        Trie node =new Trie();
        char puzzle[][]=new char[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
               puzzle[i][j]=board[i][j];
            }
        }
        for(int i=0;i<words.length;i++){
            String word = words[i];
            setupTrie(node, word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(node.hMap.containsKey(board[i][j])){
                    dfs( board, i,j,node,visited);
                    copyAgain(board, puzzle);
                }
                
            }
        }
        List<String> ans = new ArrayList<>();
        for(String str: hSet){
            ans.add(str);
        }
        return ans;
    }
    public static void copyAgain(char board[][], char puzzle[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
               board[i][j]=puzzle[i][j];
            }
        }
    }
    public static void dfs(char board[][], int i, int j, Trie find, boolean visited[][]){
        if(find.isEnded){
            hSet.add(find.corr);
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return;
        }
        if(visited[i][j]){
            return;
        }
        if(find.hMap.containsKey(board[i][j])){
            visited[i][j]=true;
            dfs(board, i+1, j, find.hMap.get(board[i][j]),visited);
            dfs(board, i-1, j, find.hMap.get(board[i][j]),visited);
            dfs(board, i, j-1, find.hMap.get(board[i][j]),visited);
            dfs(board, i, j+1, find.hMap.get(board[i][j]),visited);
            visited[i][j]=false;
        }
        
    }
    public static void setupTrie(Trie root ,String word){
        Trie dummyNode = root;
        for(int j=0;j<word.length();j++){
            if(dummyNode.hMap.containsKey(word.charAt(j))){
                 dummyNode = dummyNode.hMap.get(word.charAt(j));
            }else{
                dummyNode.hMap.put(word.charAt(j), new Trie());
                dummyNode = dummyNode.hMap.get(word.charAt(j));
            }
            if(j==word.length()-1){
             dummyNode.isEnded=true;
             dummyNode.corr = word;
         }
        }
    }
}

class Trie{
    HashMap<Character, Trie> hMap = new HashMap<>();
    boolean isEnded = false;
    String corr ;
}
// // [["a","b","c"],["a","e","d"],["a","f","g"]]
// ["abcdefg","gfedcbaaa","eaabcdgfa","befa","dgc","ade"]