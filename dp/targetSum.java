// topDown
/*
intution:
adding 2000 index as it doesn't exceed end. as max sum given 1000. and +1000 for negative side.
until position equals target recursively add and remove numbers of array index. at each position and sum is stored at dp array.
as+1000 for negative side.
*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int dp[][] = new int[nums.length][2001];
          for (int[] row: dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return helper(nums,S,0,0,dp);
    }
    int helper(int[] nums,int s,int position,int target,int dp[][]){
        if(position==nums.length){
            return s==target ? 1 :0;
        }
        else{
        if(dp[position][target+1000]!=Integer.MIN_VALUE)
            return dp[position][target+1000];
        }
       int add= helper(nums,s,position+1,target-nums[position],dp);
        int sub=   helper(nums,s,position+1,target+nums[position],dp);  
        dp[position][target+1000]= add+ sub;
         return  dp[position][target+1000];
    }
}

/*
time complexity:O(nm)
space complexity:O(nm)
*/
