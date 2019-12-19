/* explanation
maximum diameter may pass with root or without root.
here we finding maximum depth from root to left + root to right for every node.
if max at each node it is greater than it's previous max depth we update it.
*/
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int max[] = new int[1];
        maxDepth(root,max);
        return max[0];
    }

    private int maxDepth(TreeNode root,int max[]) { 
        if (root == null) {
            return 0;
        }
        int L = maxDepth(root.left,max);
        int R = maxDepth(root.right,max);
        max[0] = Math.max(max[0], L + R); 
        return 1 + Math.max(L, R);
    }
} 

/* 
time complexity:O(n)
space complexity: O(n) for recursive calls.
reference: https://leetcode.com/problems/diameter-of-binary-tree/discuss/402015/Java-Solution-%2B-Explanation
*/
