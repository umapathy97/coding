class Solution {
    public int minCut(String s) {
    
    // pattern for matrix chain multiplication problems
    
    /*
    Formula:
    Matrix chain =  (i..k) + (k+1..j) + current cost
        return helper(s,0,s.length()-1);
        
    }
    
    int helper(String s, int start, int end) {
        if(start >= end)
            return 0;
            
        int min1 = Integer.MAX_VALUE;
        if(isPalindrome(s,start,end))
            return 0;
            
        for (int i = start; i < end; i++) {
            int min = helper(s,start,i) + helper(s,i+1,end) + 1;
            min1 = Math.min(min, min1);
        }
       
     
        return min1;
    }
    
    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        
        return true;
    }
}
