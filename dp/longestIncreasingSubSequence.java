//DP based solution
/*
Intution:
    Consider small subsequences. for adding new number check it with current subsequence. if it is greater than add it .
    */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int cache[]= new int[nums.length];
        if (nums.length==0)
            return 0;
        int max=1;
        Arrays.fill(cache,1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                cache[i]=Math.max(cache[i],cache[j]+1);         
            }
            max=Math.max(max,cache[i]);           
        }
        return max;
    }
}
/*
time complexity: O(n^2)
space complexity: O(n)
beats 65% time complexity and 90% space complexity.
*/

