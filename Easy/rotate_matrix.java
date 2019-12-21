class Solution {
    public void rotate(int[][] matrix) {
       for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[i].length;j++){
               int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            int start=0;
            int end=matrix.length-1;
            while(start<=end){
                int temp = matrix[i][end];
                matrix[i][end]=matrix[i][start];
                matrix[i][start]=temp;
                start++;
                end--;
            }
        }
    }
}

/* time complexity: O(n)
space complexity:O(1) [inplace] beats 100%^ space and time
*/
