package code;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class may27 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arrLen = sc.nextInt();
        int array[][]=new int[arrLen][2];
        for(int i=0;i<arrLen;i++){
            array[i][0]=sc.nextInt();
            array[i][1]=sc.nextInt();
        }
        System.out.println(possibleBipartition(n, array));
    }
    public static boolean possibleBipartition(int N, int[][] dislikes) {
        ArrayList<Integer> mp []=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            mp[i]=new ArrayList<>();
        }
        for(int i=0;i<dislikes.length;i++){
            mp[dislikes[i][0]].add(dislikes[i][1]);
            mp[dislikes[i][1]].add(dislikes[i][0]);
        }
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=1;i<=N;i++){
            if(!hm.containsKey(i)){
                stack.push(i);
                hm.put(i,0);
                while(!stack.isEmpty()){
                    int item = stack.pop();
                    for(int temp : mp[item]){
                        if(!hm.containsKey(temp)){
                            hm.put(temp, (hm.get(item)+1)%2);
                            stack.push(temp);
                        }else if(hm.get(temp)==hm.get(item)){
                            return false;
                        }
                    }
                }
            }
           
        }
        return true;
    }
}
//[[1,2],[3,4],[4,5],[3,5]]