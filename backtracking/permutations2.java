class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permute(result,nums,new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
    public void permute( List<List<Integer>> result,int nums[], List<Integer> combs,boolean visited[]){
       if(combs.size()==nums.length){
           result.add(new ArrayList<Integer>(combs));
           return;
        }
        /*
      *  here array contains duplicates.
      * constraints are we need not use same elements twice.
      *  but each element in array should be considered.
      * hence we cannot check temp.contains step.
      *  instead we used an visited array and record if each position is already visited.
      *  by doing so, we are not visiting same element twice.
      * same wise if previous element and current element are same and previous is not visited means, we can skip this
         as this leads to repeated steps.
         */
        for(int i=0;i<nums.length;i++){
            if(visited[i] || (i>0 && nums[i]==nums[i-1] && !visited[i - 1]))
                continue;
            combs.add(nums[i]);
            visited[i]=true;
            permute(result,nums,combs,visited);
            combs.remove(combs.size()-1);
            visited[i]=false;
           
        }
      
    }
}
/*
time complexity:O( N! * N)
space complexity:O(n)
*/
