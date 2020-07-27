package code;

import java.util.Scanner;

public class july21 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=new String[sc.nextInt()];
        sc.skip("\n");
        for(int i=0;i<str.length;i++){
           str[i]=sc.nextLine();
        }
        char board[][]=new char[str.length][str[0].length()];
        for(int i=0;i<str.length;i++){
            board[i]=str[i].toCharArray();
        }
        String word = sc.nextLine();
        System.out.println(exist(board, word));
    }
    public static  boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board, word,0, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(char board[][], String word, int wordPoint, int i, int j ){
        if(word.length()<=wordPoint){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length ){
            return false;
        }
    
        char temp = board[i][j];
        if(word.charAt(wordPoint)==board[i][j]){
            board[i][j]='*';
            if(dfs(board, word, wordPoint+1,i+1,j)) return true;
            if ( dfs(board, word, wordPoint+1,i-1,j)) return true;
            if ( dfs(board, word, wordPoint+1,i,j+1)) return true;
            if ( dfs(board, word, wordPoint+1,i,j-1)) return true;
            
        }
        board[i][j]=temp;
        return false;
    }
}