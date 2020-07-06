package code;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class may19 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StockSpanner stock = new StockSpanner();
        for(int i=0;i<n;i++){
            System.out.println(stock.next(sc.nextInt()));
        }
    }
}
class StockSpanner{
  
    Stack<StockSpanner> mainStack = new Stack<>();
    int price;
    int res;
    public StockSpanner(){
    }
    public StockSpanner(int price, int res){
        this.price=price;
        this.res = res;
    }
    public int next(int price){
        int res =1;
        while(!mainStack.isEmpty() && mainStack.peek().price<=price){
            res+=mainStack.pop().res;
        }
        mainStack.push(new StockSpanner(price,res));
        return res;
    }
    
}