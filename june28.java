package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class june28 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        sc.skip("\n");
       List<List<String> >tickets = new ArrayList<List<String>>(n);
        for (int i = 0; i < n; i++) {
            ArrayList<String>tempList = new ArrayList<>();
            tempList.add(sc.nextLine());
            tempList.add(sc.nextLine());
            tickets.add(tempList);
        }
        findItinerary(tickets);
    }
    public static List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, ArrayList<String>> hMap = new HashMap<>();
        
        for(int i=0;i<tickets.size();i++){
            String src =tickets.get(i).get(0);
            String dst =tickets.get(i).get(1);
            if(hMap.containsKey(src)){
                ArrayList <String> tempList = hMap.get(src);
                tempList.add(dst);
                hMap.put(src, tempList);
            }
            else{
                ArrayList<String> tempList =new ArrayList<>();
                tempList.add(dst);
                hMap.put(src, tempList);
            }
        }
        for(Map.Entry<String, ArrayList<String>> entry : hMap.entrySet()){
            Collections.sort(entry.getValue());
        }
        LinkedList<String> list =new LinkedList<String>();
        dfs("JFK",hMap,list);
        return list;
        
    }
    public static void dfs(String Ppoint, HashMap<String, ArrayList<String>> hm, List<String> ans){
        ArrayList<String> list = hm.get(Ppoint);
        while(list!=null && list.size()!=0){
            String dst = list.get(0);
            list.remove(0);
            dfs(dst, hm , ans);
        }
        ans.add(Ppoint);
    }
}
// [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]