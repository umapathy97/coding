class Solution {
    public int minDistance(String word1, String word2) {
        int cache[][] = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<cache.length;i++)
            cache[i][0]=i;
         for(int i=0;i<cache[0].length;i++)
            cache[0][i]=i;
         for(int i=1;i<cache.length;i++)
            {
              for(int j=1;j<cache[i].length;j++){
                   if (word1.charAt(i-1) == word2.charAt(j-1)) 
                      cache[i][j] = cache[i-1][j-1];
                  else
                      cache[i][j]= 1+ (Math.min(cache[i-1][j],Math.min(cache[i-1][j-1],cache[i][j-1])));
              }
         }
                                       return cache[cache.length-1][cache[0].length-1];
    }
}




/*
time complexity:O(nm) 
space complexity:O(nm)
 beats 100% space and time
 */
