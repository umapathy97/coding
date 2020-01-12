class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0 || (needle.length()==0 && haystack.length()==0))
            return 0;
        int i=0;
        if(needle.length()>haystack.length())
            return -1;
        while(i<haystack.length()-needle.length()+1){
            int j=0;
            while(j<needle.length()  && haystack.charAt(i+j)==needle.charAt(j)){
            j++;
            }
            if(j==needle.length())
                return i;
            j=0;
            i++;
        }
        return -1;
    }
}
 /*
 time complexity:O(n*m)
 space complexity:O(1)
 beats 40% time and 50% space complexity.
 reference: https://www.youtube.com/watch?v=bzoCm_w8yx0
 */
