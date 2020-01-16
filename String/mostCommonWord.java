QUESTION SOURCE: https://leetcode.com/problems/most-common-word/
//set and map based solution.
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> ban= new HashSet<>();
        Map<String,Integer> map=new HashMap<>();
        int maxcount=Integer.MIN_VALUE;
        String result="";
        // split method will split based on conditions given. and we convert that string to string array.
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        for(String word: banned){
            ban.add(word);
        }
        for(String word:words){
            if(!ban.contains(word)){
                map.put(word,map.getOrDefault(word,0)+1);
                if(maxcount<map.get(word))
                {
                maxcount=map.get(word);
                result=word;
                }
            }
        }
        return result;
    }
}
/*
time complexity:O(n)
space complexity:o(n+n)
beats 80% time and 5.7 space.
reference: https://www.youtube.com/watch?v=q2v5nik5vwU&t=48s
