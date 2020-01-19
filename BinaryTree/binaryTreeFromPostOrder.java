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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    // hashmap is used to find index of post order in inorder.
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(postorder.length-1,0,inorder.length-1,0,postorder,inorder,map);
    }
    /*
    pstart= denotes starting of post order (from end). as in postorder root is at end.
    pend= denotes ending of post order in array.
    istart=denotes starting of inorder array(here from right side).
    as inorder stores left->root->right
       postorder stores left->right->root.
      iend= denotes ending of inorder array.
      */
    TreeNode helper(int pstart,int pend,int istart,int iend,int[] postorder,int[]inorder,
                   Map<Integer,Integer>map){
       // base case. if our pstarts exceeds pend implies all elements are covered.same for rest.
        if(pstart<pend || istart<iend)
            return null;
            // create a new treenode and store the root value which is present at starting of postorder i.e pstart.
        TreeNode root=new TreeNode(postorder[pstart]);
        // get mapping of our pstart in inorder array.
        int index= map.get(postorder[pstart]);
        /*
        for preorder we first build left and then right.
        for postorder here we start with right tree first as it is convenient.
        for our right our next root i.e . pstart will be in pstart-1 as in preorder next right will be just behind this.
                   our end pend will be our current root - number of right trees+1.as we need last index of current right tree.
        */   
        root.right= helper(pstart-1,pstart-(istart-index),istart,index+1,postorder,inorder,map);
        /*
        for our left tree our pstart will be  current root - number of right trees.which denoted by inorder start - 
        our mapping index.
        */
        root.left=helper(pstart-(istart-index)-1 ,pend,index-1,iend,postorder,inorder,map);
        return root;
    }
}
/*
time complexity:O(n) 
space complexity:O(n) for hashmap.
beats 95.6% time and space 7.1%
*/

    
