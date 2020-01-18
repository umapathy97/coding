class Solution {
    public int mySqrt(int x) {
        if(x<2)
            return x;
        int low=1;
        int high=x;
        while(low<=high){
            int mid=(low+high)/2;
            // overflow may occur if use mid*mid
            if(mid==x/mid)
                return mid;
            else if(mid>x/mid)
                high=mid-1;
            else
            {
                low=mid+1;
                result=mid;
            }
        }
        return result;
    }
}

/*
time complexity:O(logn)
space complexity:O(1)
*/
