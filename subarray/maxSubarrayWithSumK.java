/**Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example
Example1

Input:  nums = [1, -1, 5, -2, 3], k = 3
Output: 4
Explanation:
because the subarray [1, -1, 5, -2] sums to 3 and is the longest.
Example2

Input: nums = [-2, -1, 2, 1], k = 1
Output: 2
Explanation:
because the subarray [-1, 2] sums to 1 and is the longest.
Challenge
Can you do it in O(n) time?

Notice
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.


**/

public class Solution {
    /**
     * @param nums: an array
     * @param k: a target value
     * @return: the maximum length of a subarray that sums to k
     */
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            // update running sum
            sum += nums[i];
            
            // if sum - k is found, implies there is a subarray whose sum equals k exists
            if (map.containsKey(sum - k)) {
                
                // update max length from current index - starting index of current subarray
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }
            else
            map.putIfAbsent(sum,i);
            
        }
        return maxLength;
    }
}

/**
    Time Complexity: O(n)
    Space Complexity : O(n)
**/

// trails:
/**
 * 
 * [1,-1,5,-2,3]
3


{  
    1, 0
    0, 1
    5, 2
    
    
}

[-2,-1,2,1]
{
-2, 0
-3, 1
-1, 2


}
 * 
 * **/
