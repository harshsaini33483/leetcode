package code;

import java.util.Scanner;

public class june17 {
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
        solve(board);
        
    }
    public static void solve(char[][] board) {
        //TOP
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                board=removeO(board,0,i);
            }
        }
        //LEFT
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                board=removeO(board,i,0);
            }
        }
        //RIGHT
        for(int i=0;i<board.length;i++){
            if(board[i][board[0].length-1]=='O'){
                board=removeO(board,i,board[0].length-1);
            }
        }
        //BOTTOM
        for(int i=0;i<board[0].length;i++){
            if(board[board.length-1][i]=='O'){
                board=removeO(board,board.length-1,i);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if((board[i][j]=='1' || board[i][j]=='O' )){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }
        System.out.println();
    }
    public static char [][] removeO(char board[][], int i, int j){
        //TOP
        if(i<0 || i>=board.length || j>=board[0].length || j<0 || board[i][j]=='1'){
           return board;
        }
        if(board[i][j]=='2' || board[i][j]=='X'){
            board[i][j]='2';
            return board;
        }
        board[i][j]='1';
        removeO(board, i-1, j);
        removeO(board, i+1, j);
        removeO(board, i, j-1);
        removeO(board, i, j+1);
        return board;
    }
}