class KthLargest {
    int nums[];
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.nums=nums;
        this.k=k;
        pq=new PriorityQueue<Integer>(k);
        
       for(int i=0;i<nums.length;i++){
            
           add(nums[i]);
        }
    }
     /*
     each time calling this method computes priority queue and if peek is less than current value, peek value is
     useless.Remove it and add our values. if queue size is less than k then also populate the queue.
     at any time front of our queue contains k largest.
     */
    public int add(int val) {
        if(pq.size()<k)
            pq.add(val);
       else if(pq.peek()<val){
        pq.poll();
        pq.add(val);}
           
        return pq.peek();
    }
}
/*
time complexity:O((n-k)*logk)  or //O(n log n + (n - k) log k)
space complexity:O(k)
*/
