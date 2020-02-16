class Solution {
    public int subarraySum(int[] nums, int k) {
    // map to store prefix sum upto current index and their occurence.
        HashMap<Integer,Integer> map = new HashMap<>();
        int cursum=0;
        int result=0;
     //   map.put(0,1);
        for(int num:nums){
            cursum+=num;
            // when current sum equals k increment count
             if (cursum == k)   
                result++;  
                // when currentsum-k exists in map indicates we previously visited that number and hence increments the count.
           result+= map.getOrDefault(cursum-k,0);
           // put current prefix sum along with occurence.
            map.put(cursum,map.getOrDefault(cursum,0)+1);
        }
        return result;
    }
}
/*
time complexity:O(n)
space complexity:O(n)
*/
