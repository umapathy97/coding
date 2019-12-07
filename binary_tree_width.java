class Solution {
     public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }
    
    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        if(start.size() == level){
            start.add(order); end.add(order);
        }
        else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}
/*DFS SOLUTION
Time complexity:o(n) spca ecomplexity;o(n)
beats 99.9% time and 100%space
*/

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
    public int widthOfBinaryTree(TreeNode root) {
      if(root==null)
        return 0;
        Queue<TreeNode> queue = new LinkedList<>();
queue.add(root);
      HashMap<TreeNode,Integer> map = new HashMap<>();
      map.put(root,1);
      int result=0;
      
      while(!queue.isEmpty()){
        int size = queue.size();
        int start = 0;
        int end = 0;
       
        for(int i=0;i<size;i++){
        TreeNode temp = queue.poll();
          if(i == 0) 
            start = map.get(temp);
          if(i == size - 1)
            end = map.get(temp);
          if(temp.left!=null){
            queue.add(temp.left);
            map.put(temp.left,map.get(temp)*2);
          }
          if(temp.right!=null){
            queue.add(temp.right);
            map.put(temp.right,map.get(temp)*2+1);
          }
          }
         result = Math.max(end-start+1,result);
        }
      
      return result;
    }
}
/* bfs solution [:sol]
time complexity:o(n)
space complexity:o(n)
beats 40% time and 100% space 
*/
