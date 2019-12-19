class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        // k may be greater than array length. so we which is larger to k.
       reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        // to rotate array right k shifts with constant space in linear time
    }
    void reverse(int nums[], int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start]= nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
/*
Input: [1,2,3,4,5,6,7] and k = 3
 Output: [5,6,7,1,2,3,4]
 first reverse entire array              7 6 5 4 3 2 1
 reverse from 0 to k-1 i.e 0 to 2        5 6 7 4 3 2 1
 reverse from k to array length          5 6 7 1 2 3 4
 */
 
 
 /* time complexity :o(n) linear time
 space complexity:o(1) no extra space used.
 */
