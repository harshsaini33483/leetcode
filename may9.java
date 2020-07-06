package code;

public class may9 {
    public boolean isPerfectSquare(int num) {
        Long half=num/2L;
        Long start=0L;
        Long end =half+2;
       while(start<end){
           Long mid = (Long)(start+(end-start)/2);
       //    System.out.println(start+"   "+end+ "  "+mid+"  "+mid*mid);
           if(mid*mid==num){
               return true;
           }
           if(mid*mid>num){
               end = mid;
            }else{
               start=mid+1;
           }
       }
        return false;
    }

}