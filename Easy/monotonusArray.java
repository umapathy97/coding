class Solution {
    public boolean isMonotonic(int[] A) {
        if(A.length<=1)
            return true;
     if(A[0]<A[1]){
        return isascending(A);
             
     }
        else if (A[0]>A[1]){
          return isdescending(A);
        }
        else{
           return  isascending(A) || isdescending(A);
        }
    }
    boolean isascending(int[] A){
         int i=1;
         while(i<A.length-1 && A[i]<=A[i+1])
             i++;
         if(i!=A.length-1)
             return false;
            return true;
    }
   boolean isdescending(int A[]){
         int i=A.length-1;
            while(i>=1 && A[i]<=A[i-1])
                i--;
            if(i>1)
                return false;
       return true;
    }
}
/* beats 100 % space and time.
/*
time complexity:O(n)
space complexity:O(1)
*/
//smart solution
class Solution {
    public boolean isMonotonic(int[] A) {
        int inc=1;
        int dec=1;
        for(int i=1; i<A.length; i++){
            if(A[i] - A[i-1] > 0)
                inc++;
            else if(A[i] - A[i-1] < 0)
                dec++;
            else {
                inc++; dec++;
            }
                
        }
        return inc == A.length || dec == A.length;
    }
}
