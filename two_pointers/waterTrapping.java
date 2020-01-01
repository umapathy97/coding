//using one array for storing left
class Solution {
    public int trap(int[] height) {
        int totalAmount = 0;
        if (height == null || height.length == 0) {
            return totalAmount;
        }
        
        int[] leftHighest = new int[height.length + 1];
        leftHighest[0] = 0;   
        // for each index we storing maximum for it from it's left side.
        for (int i = 0; i < height.length; i++) {
            leftHighest[i + 1] = Math.max(leftHighest[i], height[i]);            
        }
        // we come from back and for index if current value is less than its left and right boundaries then water can be stored there.
        int rightHighest = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightHighest = Math.max(height[i], rightHighest);
            totalAmount += Math.min(leftHighest[i], rightHighest) > height[i] ? Math.min(leftHighest[i], rightHighest) - height[i] : 0;            
        }
        
        return totalAmount;
    }
}
/*
time complexity:O(n)
space complexity:O(n)
*/
// two pointer approach:
class Solution {
    public int trap(int[] height) {
       int right_max=Integer.MIN_VALUE;
        int left_max=Integer.MIN_VALUE;
        int left=0;
        int right=height.length-1;
        int result=0;
        while(left<right){
            if(height[left]<height[right]){
               if( height[left]>=left_max) 
                   left_max=height[left++];
               else
                    result+=(left_max-height[left++]);
            }
            else{
                if(height[right]>=right_max)
                    right_max=height[right--];
                else
                    result+=right_max-height[right--];
            }
        }
       return result; 
    }
}
/*
time complexity:O(n)
space complexity:O(1)
*/
