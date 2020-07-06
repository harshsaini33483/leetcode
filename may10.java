package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class may10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int arr[][]=new int[t][2];
        for(int i=0;i<t;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        System.out.println(findJudge(n, arr));

    }
    public static int findJudge(int N, int[][] trust) {
        // ArrayList<Integer> people[]= new ArrayList[N];
        // ArrayList<Integer> revpeople[]= new ArrayList[N];

        // for(int i=0;i<N;i++){
        //     people[i]=new ArrayList<>();
        //     revpeople[i]=new ArrayList<>();

        // }
        // for(int i=0;i<trust.length;i++){
        //     people[trust[i][0]-1].add(trust[i][1]-1);
        //     revpeople[trust[i][1]-1].add(trust[i][0]-1);
        // }
        // for(int i=0;i<people.length;i++){
        //     boolean ok =true;
        //     if(people[i].size()==0 && revpeople[i].size()==N-1){
        //         return i+1;
        //     }
        // }
        // HashSet<Integer> hs1=new HashSet<>();
        // HashSet<Integer> hs2=new HashSet<>();
        // for(int i=0;i<people[0].size();i++){
        //     hs1.add(people[0].get(i));
        // }
        // for(int i=1;i<N;i++){
        //     for(int j=0;j<people[i].size();j++){
        //         if(i%2!=0){
        //             if(hs1.contains(people[i].get(j))){
        //                 hs2.add(people[i].get(j));
        //             }
        //         }else{
        //             if(hs2.contains(people[i].get(j))){
        //                 hs1.add(people[i].get(j));
        //             }
        //         }
        //     }
        //     if(i%2!=0){
        //         hs1.clear();
        //     }else{
        //         hs2.clear();
        //     }
        // }

        // if(!hs1.isEmpty() && hs1.size()==1){
        //     for(int i:hs1){
        //         return i+1;
        //     }
        // }
        // else if(!hs2.isEmpty() && hs2.size()==1){
        //     for(int i:hs2){
        //         return i+1;
        //     }
        // }
        // return -1;


        //Optimal
        int arr[]=new int[N];
        Arrays.fill(arr,0);
        for(int i=0;i<trust.length;i++){
            ++arr[trust[i][1]-1];
            --arr[trust[i][0]-1];
        }
        for(int i=0;i<N;i++){
            if(arr[i]==N-1){
                return i+1;
            }
        }
        return -1;
    }
}