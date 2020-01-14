/*
here we can rob alternate houses.
one approach is use an dp array and store profit upto that houses.
for i th house profit could be max of (i-2)+current and (i-1).
i-1 represents previous hose.
*/

class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        int previous_before_profit=0;
        int previous_profit=nums[0];
        int current_profit=0;
        for(int i=1;i<nums.length;i++){
            current_profit=nums[i];
            current_profit= Math.max(previous_before_profit+current_profit,previous_profit);
            previous_before_profit=previous_profit;
            previous_profit=current_profit;
        }
        return previous_profit;
    }
}
/*
time complexity:
O(n)
space complexity:O(1)
beats 100% time and 95.6% space
*/
