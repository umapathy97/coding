//brute force solution
/*
Approaches:
brute force: take every window of size k and choose maximum from that. complexity(nk)
binary tree approach: use self balancing binasry serach tree complexity O(nlogk)
best approach: using deque complexity O(n)
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)
            return new int[0];
        int result[] =new int[nums.length-k+1];
        int r=0;
        for(int i=0;i<nums.length-k+1;i++){
            int max =Integer.MIN_VALUE;
            for(int j=i;j<k+i;j++){
                max = Math.max(nums[j],max);
            }
            result[r++]=max;
        }
        return result;
    }
}
/*Time complexity: O(n^2)
  Space complexity:O(1)
  */
 
// best solution using deque
/*
Approach:
Keep only useful elements in the deque anytime.
At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window. This means

If an element in the deque and it is out of i-(k-1), we discard them. We just need to poll from the head, as we are using a deque and elements are ordered as the sequence in the array

Now only those elements within [i-(k-1),i] are in the deque. We then discard elements smaller than a[i] from the tail. This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window: a[i] would always be a better candidate.

As a result elements in the deque are ordered in both sequence in array and their value. At each step the head of the deque is the max element in [i-(k-1),i]
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        if(nums.length==0)
            return new int[0];
        int result[] =new int[nums.length-k+1];
        int n = nums.length;
        int ri = 0;
        for(int i=0;i<n;i++){
          while(!queue.isEmpty() && queue.peek()<i-k+1)
              queue.poll();
        
        while((!queue.isEmpty()) && nums[queue.peekLast()] < nums[i])
        {
            queue.pollLast();
        }
        queue.offer(i);
        if(i>=k-1)
            result[ri++] = nums[queue.peek()];
        }
        return result;
    }
}


/* 
Time Complexity:O(n) linear amortized complexity
Space Complexity:O(n) for deque data structure.
*/
  
  // using stack:
  public int[] maxSlidingWindow(int[] nums, int k) {
        Stack st = new Stack();
        for(int i = 0; i < nums.length && st.size() != nums.length-k+1 ; i++){
            st.push(nums[i]);
            int j = 0;
            for(int l = i; j < k && l < nums.length; l++){
                if(st.peek() < nums[l] ){
                    st.pop();
                    st.push(nums[l]);
                }
                j++;
            }
        }
        int[] res = new int[st.size()];
        int j = res.length -1;
        while(!st.isEmpty()){
            res[j] = st.pop();
            j--;
        }
        return res;
    }
}
  
