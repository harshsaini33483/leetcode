package code;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class aug12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        getRow(sc.nextInt());
    }
    public static List<Integer> getRow(int rowIndex) {
        Integer result[] = new Integer[rowIndex+1];
        for(int i=0;i<=rowIndex;i++){
            for(int j=i;j>=0;j--){
                if(j==0 || j==i){
                    result[j]=1;
                }else {
                    result[j]=result[j-1]+result[j];
                }
                
            }
        }
        return Arrays.asList(result);
    }
}