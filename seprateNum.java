package code;

import java.util.Scanner;

public class seprateNum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(checkSolution(str));
    }

    private static boolean checkSolution(String str) {
        if(str.charAt(0)=='0'){
            System.out.println("NO");
            return false;
        }
        for(int i=1;i<str.length()/2+1;i++){
            String strNum = str.substring(0, i);
            long num = Long.parseLong(strNum);
            int j=i;
            boolean ok =true;
            long num1 =num+1;
            while(j+strNum.length()<=str.length()){
                int firstCount = j+strNum.length()<=str.length() ? j+(strNum.length()): str.length();
                int secondCount = j+strNum.length()+1<=str.length() ? j+strNum.length()+1: str.length();

                String nextNum = str.substring(j,firstCount);
                String oneMore = str.substring(j,secondCount);
                long nextNumL = Long.parseLong(nextNum);
                long oneMoreL = Long.parseLong(oneMore);
                if(num1==nextNumL && nextNum.charAt(0)!='0' ){
                    j=firstCount;
                    num1=nextNumL+1;
                    continue;

                }
                System.out.println((num1==oneMoreL)+"   "+num1+"  "+oneMoreL+ "  "+( oneMore.charAt(0)!='0'));
                if(num1==oneMoreL  && oneMore.charAt(0)!='0'){
                    num1=oneMoreL+1;
                    j=secondCount ;
                    continue;
                }
                ok=false;
                break;

            }
            if(ok && j+strNum.length()==str.length()){
                System.out.println("YES "+num);
                return true;
            }
        }
        return false;
    }
}