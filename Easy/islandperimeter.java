class Solution {
    public int islandPerimeter(int[][] grid) {
       int perimeter = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1)
                  perimeter+=  checkboundaries(grid,i,j);
            }
        }
        return perimeter;
    }
    int checkboundaries(int[][]grid,int i,int j){
        int perimeter=0;
        if(i==0 ||  grid[i-1][j]!=1)
            perimeter+=1;
        if(i+1>grid.length-1 || grid[i+1][j]!=1)
            perimeter+=1;
         if(j==0 || grid[i][j-1]!=1)
             perimeter+=1;
        if(j+1>grid[i].length-1 || grid[i][j+1]!=1)
        perimeter+=1;
        return perimeter;
    }
}


best solution:
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
} 
 
   /*time complexity:O(n)
   space complexity:O(1)
   beats 75% time and 97% space*/
