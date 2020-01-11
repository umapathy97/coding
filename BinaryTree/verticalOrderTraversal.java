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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result= new LinkedList<>();
        int index=0;
        TreeMap<Integer,TreeMap<Integer,LinkedList<Integer>>> map = new TreeMap<>();
         helper(root,map,0,0);
       for( TreeMap<Integer,LinkedList<Integer>> entry:map.values()){
           result.add(new LinkedList<>());
           for(List<Integer> row:entry.values()){
               Collections.sort(row);
             for (int val : row) result.get(index).add(val);
           }index++;
       }
        return result;
    }
    public TreeMap<Integer,TreeMap<Integer,LinkedList<Integer>>> helper(TreeNode root, TreeMap<Integer,TreeMap<Integer,LinkedList<Integer>>> map,int distance,int index){
        if(root==null)
            return map;
        if(map.get(distance)!=null){
           TreeMap<Integer, LinkedList<Integer>> temp= map.get(distance); 
            LinkedList<Integer> res= new LinkedList<>();
            if(temp.get(index)!=null){
             res= temp.get(index);
            res.add(root.val);  }
            else
            {
                res.add(root.val);
            }
            temp.put(index,res);
            map.put(distance,temp);
        }
            else{
                TreeMap<Integer,LinkedList<Integer>> temp= new TreeMap<>();
                 LinkedList<Integer> res= new LinkedList<>();
                res.add(root.val);
                temp.put(index,res);
                map.put(distance,temp);
            }
        
        helper(root.left,map,distance-1,index+1);
         helper(root.right,map,distance+1,index+1);
        return map;
    }
}
/*
time complexity:O(nlogn)
space complexity:O(n+n)
*/
