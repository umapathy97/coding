class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        combhelper(candidates,target,result,new ArrayList<>(),0);
        return result;
    }
    void combhelper(int candidates[], int target,List<List<Integer>> result,List<Integer> combinations,int index){
        if(target==0)
        {
            result.add(new ArrayList<>(combinations));
            return;
        }
        if(target<0)
            return;
        for(int i=index;i<candidates.length;i++){
            combinations.add(candidates[i]);
            combhelper(candidates,target-candidates[i],result,combinations,i);
            combinations.remove(combinations.size()-1);
        }
    }
}



/*
Time complexity:O(n^target)
Space complexity:O(K)
reference:https://www.youtube.com/watch?v=irFtGMLbf-s&t=16s
key points learned:
For backtracking, the depth in worst case is target.
A is Array length and b is target.
I'd imagine the worst case complexity is A^B, not B^A because for loop is on all the candidates (A). AAA*...A = A^B.
For storing the path, which could be k long at most.
*/

