class Solution {
    public int threeSumClosest(int[] nums, int target) { 
        if(nums.length<3)
            return -1;
        Arrays.sort(nums);
        int closest=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length;i++){
            int start=i+1;
            int end=nums.length-1;
            /*
            if cur sum equals target return that. else if it is closer than previous update it.
            if cursum is less than target then we need to add starting element.
            else if it is greater we need to remove ending element.
            */
            while(start<end){
               int cursum=nums[start]+nums[end]+nums[i]; 
              if(cursum==target)
                return cursum;
                      else if(cursum<target)
                        start++;
                       else
                         end--;
                  if(Math.abs(cursum-target)< Math.abs(closest-target))
                   {
                    closest=cursum;
                   }
                   }
            }
                   return closest;
    }
}

/*
time complexity:O(n^2)
space complexity:O(1)
beats 95% time and 100 % space.
reference: https://www.youtube.com/watch?v=bcE3ifBNFpo
*/
