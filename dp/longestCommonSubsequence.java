class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int result[][] = new int[text1.length()+1][text2.length()+1];
       return lchelper(text1,text2,result,text1.length()-1,text2.length()-1);
        
    }
    int lchelper(String text1, String text2, int result[][],int n1,int n2){
       if(n1<0 || n2<0)
            return 0;
        if(result[n1][n2]!=0)
            return result[n1][n2];
        if(text1.charAt(n1)==text2.charAt(n2))
            result[n1][n2] = 1+ lchelper(text1,text2,result,n1-1,n2-1);
        else
            result[n1][n2] = Math.max(lchelper(text1,text2,result,n1,n2-1),lchelper(text1,text2,result,n1-1,n2));
        return result[n1][n2];
    }
}





/* top down approach beats 5.31% time and 100% space
time complexity: O(nm) as it iterates all possible combinations of both strings.
space complexity: O(nm) for 2d array.
*/
