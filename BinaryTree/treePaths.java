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
    public List<String> binaryTreePaths(TreeNode root) {
      List<String> paths = new ArrayList<>();
           if(root==null)
            return paths;
        findPath(root,paths,"");
        return paths;
    }
    void findPath(TreeNode root,List<String> paths, String path){
        path = path+ root.val;
        if(root.left==null && root.right==null)
            paths.add(path);
        if(root.left!=null)
        findPath(root.left,paths,path+"->");
        if(root.right!=null)
            findPath(root.right,paths,path+"->");
    }
}


/* time complexity: O(n)
space complexity:O(n)
*/
