class Solution {
// max for storing result
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        helper(root);
        return max;
       
    }
    int helper(TreeNode root){
        if(root==null)
            return 0;
            // recursively move to down left.
            /*
            left and right returns maximum path sum upto it. it may be negative. hence we compare with 0.
            for each node we have three possibilities.
            */
         int left=Math.max(0,helper(root.left));
        int right=Math.max(0,helper(root.right));
        // subpath returns maximum value from that node.
        // we store max value in global variable and keep updating at every node.
        int subpath = Math.max(Math.max(left,right)+root.val,root.val);
        // for each node we store maximum value (root+left+right) from that node, but send only max of (left or right)+root to the node.
        int subtree=Math.max(subpath,root.val+left+right);
        max=Math.max(max,subtree);
        return subpath;
    }
   
}

/*
time complexity:
O(n) similiar to postorder tree traversal.
space complexity:O(logn) for recursive stack.
refernce: https://www.youtube.com/watch?v=KiFHioOxkRU
*/
