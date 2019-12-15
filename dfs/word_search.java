class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j =0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0) && search(board,word,i,j,0)){
                       return true;
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board,String word, int i, int j, int count){
        if(word.length()==count)
            return true;
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]!=word.charAt(count))
            return false;
        char temp1 = board[i][j];
        board[i][j] = ' ';
     boolean temp =   search(board,word,i+1,j,count+1)
         ||search(board,word,i,j+1,count+1) 
         ||search(board,word,i-1,j,count+1)
         || search(board,word,i,j-1,count+1);
    board[i][j] = temp1;
        return temp;
        
    }
}


/*time complexity: O(M*N) where M*N is board length
Space complexity: O(n) for recursion depth
*/
