 Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
      int res[] = helper(root);
      return(Math.max(res[0],res[1]));
    }
 int[] helper(TreeNode root){
    if(root==null)
      return new int[2];
    int left[] = helper(root.left);
    int right[] = helper(root.right);
    int res[] = new int[2];
    res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
    res[1] = Math.max(left[0]+root.val+right[0],left[1]+right[1]);
    return res;
    
  }
}
// best & clear sol
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
    if(root==null)
        return 0;
       int[] result =  robhelper(root);
        return Math.max(result[0],result[1]);
    }
   int[] robhelper(TreeNode root){
        if (root==null)
            return new int[2];
        int[] result = new int[2];
        int left[]=robhelper(root.left);
        int right[]=robhelper(root.right);
        result[0]= root.val+left[1]+right[1];
        result[1]= Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return result;
        
    }
 /*
 time complexity:O(n)
 space complexity:O(1)
 */
