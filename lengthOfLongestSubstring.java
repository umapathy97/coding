// finding longest substring which is not repeating in a string
/*
approach:
traverse the string
store the next index for each character in an array. it is used to get the latest updated index;
in case of duplicate values start pointer may points to initial part of array, it may also contains duplicates after that.
hence this array use we move start to next non duplicate value.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start =0;
        int counter=0;
         int array[] = new int[128];
        for(int end=0;end<s.length();end++){
           start = Math.max(array[s.charAt(end)],start);
            counter = Math.max(counter,end-start+1);
            array[s.charAt(end)] = end+1;
            
        }
        return counter;
    }
}


/*
time complexity:O(n)
space complexity:O(1)
*/
