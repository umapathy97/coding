/*
Intution:
copy element from fast index to slow index if they are not same.
return slow index;
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow=0;
        int fast=0;
        while(fast<nums.length && slow<nums.length){
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
            slow++;}
            fast++;
        }
        return slow;
    }
}
/*
time complexity:O(n)
space complexity:O(1)
*/
