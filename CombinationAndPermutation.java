package code;

class CombinationAndPermutation {
    public String str = "abc";
 public int i = 0; //work as binary array
 public static void main(String[] args) {
    CombinationAndPermutation cp = new CombinationAndPermutation();
  cp.combinations();
  System.out.println("Combination");
 // cp.permutations();
 }
 
 /**
  * Loop through numbers from 1 to 2^length
  * For each number if bit is set, append them
  */
 private void combinations() {
  int n = str.length();
  System.out.println(1<<n);
  for (int i = 1; i < (1 << n); i++) {
   String s = "";
   for (int j = 0; j < n; j++) {
       System.out.println(i+" "+(1<<j) +" "+ (i & 1<<j));
    if ((i & 1<<j) != 0) {
     // append chars for set bit
     s += str.charAt(j);
    }
   }
   System.out.println(s);
  }
 }
 
 /**
  * @param res
  * current permutation string formed
  * @param set
  * current set of characters from which permutation needs to be formed
  */
 private void permutations(String res,String set) {
  if(res.length()==set.length()) System.out.println(res);
  for(int j=0;j<set.length();j++) {
   if((i&1<<j) == 0) {
    i|=1<<j; //set available free 0 bit
    permutations(res+set.charAt(j),set);
    i&=~(1<< j); //unset that bit to 0
   }
  }
 }
 /**
  * For each combination found , find all its permutation
  * same code as combination
  */
 private void permutations() {
  int n = str.length();
  for (int i = 1; i < (1 << n); i++) {
   String s = "";
   for (int j = 0; j < n; j++) {
    if ((i & 1<<j) != 0) {
     // append chars for set bit
     s += str.charAt(j);
    }
   }
   permutations("",s);
  }
 }
}
