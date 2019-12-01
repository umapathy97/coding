class Solution {
    public List<Integer> partitionLabels(String S) {
    // array to map last occurence for each characters.
     int countmapping[] = new int[26];
      int  last=0;int i=0;
      List<Integer> result = new ArrayList<>();
      for(int k=0;k<S.length();k++){
        countmapping[S.charAt(k)-'a'] = k;
      }
      while(i<S.length()){
          last = countmapping[S.charAt(i)-'a'];
        int j = i;
        //from current character find if any character eqauls last boundary .upto that expands our last boundary.
        while(j!=last){
         last = Math.max(last, countmapping[S.charAt(j++)-'a']);
        }
         result.add(j-i+1);
        i= j+1;
      }
  return result;
    }
}
//time complexity(o(n)
//space complexity o(1) as countmapping is constant array and result result is not calculated.
