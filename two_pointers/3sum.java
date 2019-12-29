class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
      Arrays.sort(nums);
      for(int i=0;i<nums.length;i++){
        if (i > 0 && nums[i] == nums[i - 1]) {          
            continue;
        }
        int start=i+1;
         int end=nums.length-1;
        while(start<end){
          if(nums[start]+nums[end]+nums[i]==0)
            result.add(Arrays.asList(nums[i],nums[start],nums[end]));
          if(nums[start]+nums[end]+nums[i]<0) {
           int current = start;
           while(nums[current]==nums[start] && start<end){
           start++;}}
          else
          {
            int current = end;
             while(nums[current]==nums[end] && start<end){
          end--;}
          }
        }
      }
      return result;
    }
}
//best sol:

public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>(); 
    for (int i = 0; i < num.length-2; i++) {
        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
           }
        }
    }
    return res;
}

/*time complexity: o(n2)
space complexity:o(1)
refer: https://www.youtube.com/watch?v=-AMHUdZc9ss&t=1283s */
