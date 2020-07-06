package code;
import java.io.*;
import java.util.*;


class IndexClass {
    int no;
    int index;
}
class SortIndex implements Comparator<IndexClass>{
    public int compare(IndexClass a, IndexClass b){
        return a.no-b.no;
    }
}
public class StrongestPermu {

    // Complete the largestPermutation function below.
    static int[] largestPermutation(int k, int[] arr) {
        int sameArray[]=new int[arr.length];

        if(k>=arr.length){
            Arrays.sort(arr);
            for(int i=arr.length-1;i>=0;i--){
                sameArray[arr.length-1-i]=arr[i];
            }
            return sameArray;
        }
        ArrayList<IndexClass> diffArray=new ArrayList<IndexClass>();
        for(int i=0;i<arr.length;i++){
            IndexClass index = new IndexClass();
            index.no=arr[i];
            index.index = i;
            diffArray.add(index);
        }
        Collections.sort(diffArray,new SortIndex());
        int end =arr.length-1;
        HashMap<Integer, Integer> hm=new HashMap<>();
        int start =0;
        while(k>0 && end>=0){
            IndexClass temp = diffArray.get(end);
            if(temp.no==arr[start]){
                ++start;
                --end;
                continue;
            }
            if(hm.containsKey(temp.no)){
               int maxIndex= hm.get(temp.no);
               int startNo = arr[start];
               hm.put(startNo, maxIndex);
                arr[start]=temp.no;
                arr[maxIndex]=startNo;
               
            }else{
                hm.put(arr[start], temp.index);
                int tempStart = arr[start];
                arr[start] = arr[temp.index];
                arr[temp.index]=tempStart;
            }
           ++start;
           --end;
           --k;
        }
      
      
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedWriter = new BufferedReader(new InputStreamReader(System.in));
        int n = scanner.nextInt();

        int k = scanner.nextInt();

        int[] arr = new int[n];

       

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            arr[i] = arrItem;
        }

        int[] result = largestPermutation(k, arr);

        for (int i = 0; i < result.length; i++) {
            
            System.out.print(result[i]+" ");
        }

        bufferedWriter.close();

        scanner.close();
    }
}
//145 161 11 116 64 85 158 167 125 14 104 34 15 119 51 118 63 188 166 113 114 194 126 53 133 109 48 40 32 52 108 62 153 105 44 129 89 186 45 73 115 66 130 56 141 197 36 192 107 24 22 152 81 137 111 101 100 144 9 16 31 154 198 159 70 179 50 172 39 155 79 37 87 69 121 134 93 7 5 17 110 122 96 103 177 193 95 33 164 71 143 82 77 75 162 191 102 19 91 94 157 184 35 23 99 180 182 6 59 176 146 13 165 135 3 4 195 112 189 30 27 168 123 41 57 136 190 29 132 76 38 1 10 83 124 163 20 117 178 2 42 84 12 171 67 43 58 183 8 138 68 149 131 47 74 60 80 90 78 160 169 21 61 187 92 25 181 147 88 106 55 97 150 120 128 139 140 175 26 127 173 185 65 196 86 28 98 54 142 18 151 46 49 170 174 156 148 72
//198 197 196 195 194 193 192 191 190 189 188 187 186 185 184 183 182 181 180 179 178 177 176 175 174 173 172 171 170 169 168 167 166 165 164 163 162 161 160 159 158 157 156 155 154 153 152 151 150 149 148 147 146 145 144 143 142 141 140 139 138 137 136 135 134 133 132 131 130 129 128 127 126 125 124 123 122 121 120 119 118 117 116 115 114 113 112 111 110 109 108 107 106 105 104 103 102 101 100 99 98 97 96 95 94 93 92 91 90 89 88 87 86 85 84 83 82 81 80 79 78 77 76 75 74 73 72 71 70 69 68 67 66 65 64 63 62 61 60 59 58 57 56 55 54 53 52 51 50 49 48 47 46 45 44 43 42 41 40 39 38 37 36 35 12 25 13 15 23 19 27 3 34 5 30 16 9 7 26 21 29 17 4 11 2 28 10 1 6 18 20 14 31 32 33 24 22 8
//137 15 196 96 194 193 115 62 69 189 89 187 186 17 184 110 182 181 153 85 64 177 87 175 113 71 172 171 170 169 101 191 161 75 164 56 162 197 160 159 103 157 39 155 111 180 152 151 82 149 148 147 146 141 33 19 91 154 140 139 138 198 136 135 134 174 132 131 156 163 128 127 176 190 7 123 122 124 120 185 44 117 195 167 178 179 112 144 183 173 168 150 106 165 188 192 102 143 142 94 66 51 35 23 99 166 63 6 59 126 81 13 105 73 3 4 116 95 14 30 27 108 70 41 57 145 125 29 50 76 38 1 10 83 121 129 20 93 114 2 42 84 12 40 67 43 58 118 8 31 68 24 48 47 74 60 80 90 78 45 52 21 61 34 92 25 104 36 88 77 55 97 107 5 79 16 9 53 26 37 109 119 65 11 86 28 98 54 100 18 158 46 49 32 133 130 22 72