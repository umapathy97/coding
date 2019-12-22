/*
Approach:
i) iterate over input matrix.
ii) if current grid value is not 0, then collect maximum value from its neighbours.
Conditions:
i) each cell should be visited once.
ii) from cell i,j when we calling  it returns max sum that will get from its neighbours.
iii)we won't visit a cell twice hence we modify input array and finally we set it back
*/
class Solution {
    public int getMaximumGold(int[][] grid) {
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]!=0)
                   result = Math.max(result, dfs(i,j,grid,0));
            }
           
        }
         return result;
    }
    int dfs(int i,int j,int[][] grid,int sum){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0)
            return sum;
        int k = grid[i][j];
        sum=sum+k;
        grid[i][j]=0;
        int sum1=sum;
        sum1=Math.max(sum1,dfs(i+1,j,grid,sum));
        sum1=Math.max(sum1,dfs(i,j+1,grid,sum));
        sum1=Math.max(sum1,dfs(i-1,j,grid,sum));
        sum1=Math.max(sum1,dfs(i,j-1,grid,sum));
        grid[i][j]=k;
        return sum1;
    }
    
} 
/* time complexity: O(4^n)
   space complexity;O(n)  for recursive stack
   */
