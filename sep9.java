package code;

import java.util.Scanner;


public class sep9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String version1 = sc.nextLine();
        String version2 = sc.nextLine();
        System.out.println(  compareVersion(version1, version2));
      
    }
    public static int compareVersion(String version1, String version2) {
        // -1 for version small
        // 0 equal 
        // 1 greater
        String str1[]=version1.split("\\.");
        String str2[]= version2.split("\\.");
        int len1 = str1.length;
        int len2 = str2.length ;
        int i = 0;
        int j =0;

        while(i<len1 || j<len2){
            if(i<len1 && j>=len2){
                if(Integer.parseInt(str1[i])==0){
                    ++i;
                    continue;
                }return 1;
            }
            else if(i>=len1 && j<len2){
                if(Integer.parseInt(str2[j])==0){
                    ++j;
                    continue;
                }
                return -1;
            }else{
                int no1 = Integer.parseInt(str1[i]);
                int no2 = Integer.parseInt(str2[j]);
                if(no1<no2){
                    return -1;
                }else if(no1>no2){
                    return 1;
                }
                ++i;
                ++j;
            }
          
        }
        return 0;
    }
}
