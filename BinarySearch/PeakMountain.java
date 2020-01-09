class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int start=0;
        int end=A.length-1;
        while(start<=end){
            int mid=start + (end-start)/2;
            if( A[mid]<A[mid+1])
                start=mid+1;
            else
               end=mid-1;
        }
        return start;
    }
}
/*
time complexity:O(logn)
space complexity:O(logn) ... for recursive depth
*/
