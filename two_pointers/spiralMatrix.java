class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length==0)
            return result;
        int top=0;
        int left=0;
        int bottom = matrix.length-1;
        int right = matrix[0].length-1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                //if(top>bottom)  above case had been taken care at begiining of the loop itself.
                  //  return result;
                result.add(matrix[top][i]);
              
            }
           top++;
            for(int i=top;i<=bottom;i++){
             //   if(left>right)
               //     return result;
                result.add(matrix[i][right]);
              
            }
            right--;
            for(int i=right;i>=left;i--){
                  if(top>bottom)
                    return result;
                result.add(matrix[bottom][i]);
              
            }
            bottom--;
           for(int i=bottom;i>=top;i--){
                 if(left>right)
                    return result;
                result.add(matrix[i][left]);
              
            }
            left++;
        }
        return result;
    }
}
/*
time complexity:O(nm)
space complexity:O(nm)
beats 100% space and time
*/
