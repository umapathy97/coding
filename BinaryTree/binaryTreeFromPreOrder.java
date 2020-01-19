class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
	// hashmap stores our mapping of inorder index.
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(0,preorder.length-1,0,inorder.length-1,preorder,inorder,map);
    }
    TreeNode helper(int pstart,int pend,int istart,int iend,int[] preorder,int[]inorder,
                   Map<Integer,Integer>map){
		/*
		pstart-> starting index of preorder array.
		pend-> ending index if preorder array.
		istart-> starting index of inorder array.
		iend-> ending index of inorder array.
		*/
				   
        if(pstart>pend || istart>iend)
            return null;
        TreeNode root=new TreeNode(preorder[pstart]);
        int index= map.get(preorder[pstart]);
		/*
		in preorder next root will be in our current preorder index+1;
		*/
        root.left= helper(pstart+1,pend,istart,index-1,preorder,inorder,map);
		// for right subtree next preorder root index will be current index- number of left subtrees+1
        root.right=helper(pstart+index-istart+1,pend,index+1,iend,preorder,inorder,map);
        return root;
    }
}

/*
time complexity:O(n)
space complexity:O(n)
*/
