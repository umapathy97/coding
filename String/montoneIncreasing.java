class Solution {
    public int monotoneIncreasingDigits(int N) {
    // converting integer to string and later to char.
        char nums[]=String.valueOf(N).toCharArray();
        // starting from second last index.
        int j=nums.length-2;
        // peak variable to get index where strictly decreasing sequence starts.
        int peak=nums.length;
        while(j>=0){
          //if current number is greater than next element consider it as peak; 
            if(nums[j]>nums[j+1]){
            // here even if both numbers are same as in 332 i.e becomes 322
            //and later peaks becomes 3 and decrease to 2. 222
                peak=j;
                // after decrease the current element.
                nums[j]--;
            }
        j--;   
        }
        // runs from peak+1 element to nums length changes 299.
        for(int i=peak+1;i<nums.length;i++)
           nums[i]='9'; 
        return Integer.parseInt(String.valueOf(nums));
    }
}
/*
time complexity: : O(D)   O(D), where D \approx \log ND≈logN is the number of digits in N. Each step in the algorithm is a linear scan of the digits.
space complexity:O(D)
*/
