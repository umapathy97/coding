class Solution {
    public int nextGreaterElement(int n) {
        String num= String.valueOf(n);
        char nums[] = num.toCharArray(); 
        int j=num.length()-2;
        if(n>=Integer.MAX_VALUE)
            return -1;
            // if current digit is greater than the next digit than it is strictly decreasing sequence.
            // move to element before the element where decreasing sequence starts. it will be pivot.
        while(j>=0 && nums[j]-'0'>=nums[j+1]-'0'){
            j--;
        }
        // if we came back j less  than zero means it is in strictly decreasing order.
        if(j==-1)
            return -1;
            //if j is greater than or equals zero find first index from right which is greater than our pivot.
            //swap those number with our pivot.
        if(j>=0){
            int i = nums.length-1;
            while(j>=0 && nums[i]-'0'<=nums[j]-'0')
                i--;
            swap(nums,j,i);
        }
        // reverse the rest of elements. as after swapping it returns last permutation of that range and we need next permutation 
        // swap with next j position.
       reverse(nums, j + 1);
        try {
        // some times numberformatexception is thrown for input 199999999
        // to handle that use try catch.
        return Integer.valueOf(String.valueOf(nums));
    } catch (NumberFormatException e) {
        return -1;
    }
    }
     private void reverse(char[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
     }
     private void swap(char nums[], int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
/*
Time complexity : O(n)O(n). In worst case, only two scans of the whole array are needed.

Space complexity : O(1)O(1). No extra space is used. In place replacements are done.

beats 100% time and 100% space .

reference:https://www.youtube.com/watch?v=quAS1iydq7U
*/

