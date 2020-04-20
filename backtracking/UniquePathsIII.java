class Solution {
    int sx=0;
    int sy=0;
    int ex=0;
    int ey=0;
    int count=0;
    public int uniquePathsIII(int[][] grid) {
        int empty=1;// setting empty as 1 because we need to count end. as it is also empty
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0)
                    empty++;
                else if(grid[i][j]==1)
                {
                    sx=i;
                    sy=j;
                }
                else if(grid[i][j]==2){
                    ex=i;
                    ey=j;
                }
            }
        }
        dfs(grid,sx,sy,empty);
        return count;
    }
    void dfs(int[][] grid, int x, int y,int empty){
    // pruning the unwanted tree
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]<0)
            return;
        if(x==ex && y==ey && empty==0)
        {
            count++;
            return;
        }
         grid[x][y]=-1;
        empty--;
         dfs(grid,x+1,y,empty);
         dfs(grid,x-1,y,empty);
         dfs(grid,x,y+1,empty);
         dfs(grid,x,y-1,empty);
            grid[x][y]=0;// unsetting because for next recursion we need to be make it possible.
            empty++;
    }
}
