class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i+1])i--;
        if(i == -1){
            for(int x = 0, y = nums.length - 1; x < y; x++, y--){
                int temp  = nums[x];
                nums[x] = nums[y];
                nums[y] = temp;
            }
        }else{
            for(int j = nums.length - 1; j > i; j--){
                if(nums[j] > nums[i]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
            
            for(int k = i + 1, l = nums.length - 1; l > k; k++, l--){
                int temp  = nums[k];
                nums[k] = nums[l];
                nums[l] = temp;
            }
        }
    }
}
  
