class Solution {
/* Array contains two sorted sub parts. find pivot element i.e element which is in between those parts.
for finding that modified binary search is used.
*/
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(low<high){
            mid= low+(high-low)/2;
            if(nums[mid]>nums[high])
                low=mid+1;
            else
                high=mid;
        }
        /*
        setting start of our binary search to pivot if our target is greater than pivot or setting end to pivot if our target is
        lesser than pivot.
        */
        int start=low;
        low=0;
        mid=0;
        high=nums.length-1;
        if(target>=nums[start] && target<=nums[high])
            low=start;
        else
            high=start;
        while(low<=high){
            mid= low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}
/*time complexity:O(logn)
space complexity:O(1)
reference: https://www.youtube.com/watch?v=QdVrY3stDD4
*/
