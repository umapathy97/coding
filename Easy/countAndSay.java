/*
intution: for n=4
base case:1
1
11
21
1211
for each state count it's previous state.
*/
class Solution {
    public String countAndSay(int n) {
        String result="1";
        for(int i=1;i<n;i++){
        // stringbuilder is mutable. in loooping it will helpful.
            StringBuilder buffer=new StringBuilder();
            // upto result length count number of occurence of each letter. and append it buffer.
            for(int j=0;j<result.length();j++){
                int count=1;
                while(j+1<result.length() && result.charAt(j)==result.charAt(j+1)){
                    count++;
                    j++;
                }
             buffer.append(count).append(result.charAt(j));
                
         }
            result=buffer.toString();
        }
        return result;
    }
}
/*
time complexity: O(k * n), where k is the length of the largest sequence till n
space complexity:O(1)
*/
