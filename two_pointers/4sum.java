/*
Find four numbers that adds to target
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<4)
            return result;
          Arrays.sort(nums);
          
        for(int i=0;i<nums.length-3;i++){
        // if current and previous number are same skip it.
             if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length-2;j++){
            // if current and previous number are same skip it.
                 if(j>i+1 && nums[j]== nums[j-1]) continue;
                int start=j+1;
                int end=nums.length-1;
                // to eliminate complexity we use pointers as we already sorted the array.
                while(start<end){
                    int sum= nums[i]+nums[j]+nums[start]+nums[end];
                    if(sum==target){
                        List<Integer> temp=Arrays.asList(nums[start],nums[end],nums[i],nums[j]);
                        result.add(temp);
                    while(start<end&&nums[start]==nums[start+1])start++;
                    while(start<end&&nums[end]==nums[end-1])end--;
                    start++;
                    end--;
                    }
                    else if(sum>target)
                        end--;
                    else 
                        start++;
                        
                }
            }
        }
        return result;
    }
}
/*
time complexity:O(n^3)
space complexity:0(n^n)
beats 68% time and 80% space
*/

