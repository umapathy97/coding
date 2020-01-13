class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(k);
        for(int i=0;i<nums.length;i++){
       
            if(pq.size()<k)
            {
                pq.add(nums[i]);
            }
            else if(pq.peek()<nums[i])
            {
                pq.remove();
                pq.add(nums[i]);
            }
        }
       
        return pq.poll();
    }
}
/*
time complexity:O((n-k)*logk)
space complexity:O(k)
*/
