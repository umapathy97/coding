/*
intution:
extended version of house robber:
  here we can rob either first or last house.
  hence we can call functions with firsthouse and withhouse and get maximum of it and return.
  */
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int withfirst= robhelper(1,nums,0,nums[0],0,nums.length-1);
        int withlast=  robhelper(2,nums,0,nums[1],0,nums.length);
        return Math.max(withfirst,withlast);
        
    }
    int robhelper(int index,int[] nums,int prev_before,int prev,int current,int n){
        for(int i=index;i<n;i++){
            current=Math.max(prev_before+nums[i],prev);
            prev_before=prev;
            prev=current;
        }
    return prev;
    }
}
/*
time complexity:O(n)
space complexity:O(1)
beats 100% time and 100%space
*/
