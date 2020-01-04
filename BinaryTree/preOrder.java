// recursive version
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
            return result;
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
        
    }
}
/*
time complexity:O(n) 
space complexity:O(logn) or o(h)
beats 100% space and 100% time
*/

//iterative version
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
          List<Integer> result = new ArrayList<>();
         Stack<TreeNode> stack = new Stack<>();
        if(root==null)
            return result;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur= stack.pop();
        result.add(cur.val);
        if(cur.right!=null)
            stack.push(cur.right);
        if(cur.left!=null)
            stack.push(cur.left);
        }
        return result;
    }
}
/*
time complexity:O(n)
space complexity:O(n)
beats 100% space and 34% time
*/
