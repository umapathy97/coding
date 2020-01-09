public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        /*
        while low less than high , iterate each row, for each row stop in a position which is smaller than middle value;
        count number of numbers upto j,if it is equal to our k then return current index.
        else increment low to middle plus 1 if required k is lesser than our count. else if count greater than count move high to 
        point mid
        */
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
/*time complexity:O(nlogn) for each row we applying binary search
space complexity:O(1) 
*/


reference: https://www.youtube.com/watch?v=kdvGki08MkE
