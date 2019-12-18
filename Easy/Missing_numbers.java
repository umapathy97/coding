class Solution {
public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result= new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) {
                result.add(i+1);
            }
        }
        return result;
    }
    }



/* 
Time complwxity: o(n) 
space complexity : o(1)
another approach: adding all elements to hashset and iterate over array if every index is preswnt 
*/
