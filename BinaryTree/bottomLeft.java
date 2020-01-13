class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<>();
        int leftval=0;
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            leftval=queue.peek().val;
            for(int i=0;i<size;i++){
                TreeNode current=queue.remove();
                if(current.left!=null)
                    queue.add(current.left);
                if(current.right!=null){
                    queue.add(current.right);
                }
                    
            }
        }
        return leftval;
    }
}
/*
time complexity:O(n)
space complexity:O(n)
*/

// clever solution

public int findLeftMostNode(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        root = queue.poll();
        if (root.right != null)
            queue.add(root.right);
        if (root.left != null)
            queue.add(root.left);
    }
    return root.val;
}
