class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // if k is less than zero are n is lesser than k than it is base case.
         if(k <=0 || n < k){
        return result;
         }
        combination(n,k,result,new ArrayList<>(),1);
        return result;
    }
    void combination(int n,int k,List<List<Integer>> result,List<Integer> current_combinations,int position){
        if(current_combinations.size()==k){
            result.add(new ArrayList(current_combinations));
            return;
        }
        /* the loop may need to run n times it can run upto n-(k - current_combinations.size()) + 1
        i.e. for n=4 k==2 current_combinations=0
        4-(2-0)+1
        3. 
        as starting from 1 (1,2),(1,3),(1,4).
        for i=2 
        starting from 2 (2,3) (2,4)
        for(i=3)
        starting from 3 (3,4)..
        */
        
        
        for(int i=position;i<=n-(k - current_combinations.size()) + 1;i++){
            current_combinations.add(i);
            System.out.println(current_combinations);
            combination(n,k,result,current_combinations,i+1);
            current_combinations.remove(current_combinations.size()-1);
            
        }
    }
}
/*
time complexity:O(n^n)
space complexity:O(n)
*/

