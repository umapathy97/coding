/*
with o(nm) space
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int cache[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0)
                    cache[i][j]=1;
                else
                {
                    cache[i][j]=cache[i-1][j]+cache[i][j-1];
                }
            }
        }
        return cache[m-1][n-1];
    }
}
/*
beats 100% time and 5.1% space
time complexity:O(mn)
space complexity:O(mn)
*/
//space optimized as each state only on only values.
class Solution {
    public int uniquePaths(int m, int n) {
        int cache[] = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0)
                    cache[j]=1;
                else
                {
                    cache[j]=cache[j]+cache[j-1];
                }
            }
        }
        return cache[n-1];
    }
}
/*
beats 100% time and 5.1% space
time complexity:O(mn)
space complexity:O(n)
*/
