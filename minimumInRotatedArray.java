/* apply binary search, find mid . if mid is lesser than it's previous value and it is not first index then it is smallest number.
else, if mid is greater than it's left and right, we to go right as we are on already sorted increasing sequence.
else go left.
*/
public class Solution {
    public int findMin(int[] num) {
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }
}

/*
time complexity:O(logn)
space complexity:O(1)
*/
