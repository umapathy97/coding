class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        combhelper(candidates,target,result,new ArrayList<>(),0);
        return result;
    }
    void combhelper(int[] candidates, int target, List<List<Integer>> result,List<Integer> columns,int position){
        if(target==0){
            result.add(new ArrayList(columns));
            return;
        }
        if(target<0)
            return;
        for(int i=position;i<candidates.length;i++){
            if(i!=position  && candidates[i-1]==candidates[i] )
                continue;
            columns.add(candidates[i]);
            combhelper(candidates,target-candidates[i],result,columns,i+1);
            columns.remove(columns.size()-1);
            
        }
    }
}
/*
time complexity:O(candidates^target.
space complexity:O(depth)
beat 80% time and 100% space 
reference: https://www.youtube.com/watch?v=j9_qWJClp64
*/
