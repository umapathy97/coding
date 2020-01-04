class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return root;
        if(root==p || root==q)
            return root;
        TreeNode left_recur = lowestCommonAncestor(root.left,p,q);
        TreeNode right_recur = lowestCommonAncestor(root.right,p,q);
        if(left_recur!=null && right_recur!=null)
            return root;
      return  (left_recur!=null)?left_recur:right_recur;
        
    }
} 
/*
time complexity:O(n)
space complexity:O(h)
h is the height of the tree. in average case h=logn in worst case h=n
beats 99% time and 5% space
*/
