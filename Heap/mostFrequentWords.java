QUESTION SOURCE:https://leetcode.com/problems/top-k-frequent-words/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
    // for counting frequencies.
       HashMap<String,Integer> map = new HashMap<>();
       // for storing final result.
        List<String> result = new LinkedList<>();
        /*
        comparator is used.
        if two elements frequencies are equal we need to get element then word with lower alphabetical order should come
        first.insuch scenario for comparators we use(b-a).
        */
        PriorityQueue<Map.Entry<String,Integer>> minheap = new PriorityQueue<>((a,b)-> 
        a.getValue()==b.getValue()?b.getKey().compareTo(a.getKey()):a.getValue()-b.getValue());
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            minheap.offer(entry);
            if(minheap.size()>k)
                minheap.poll();
        }
        while(result.size()<k){
        // here in priority queue always return low to high but we require high to low.
      //  either we can always add at first or sort the result finally.
            result.add(0,minheap.poll().getKey());
        }
        return result;
    }
}
/*
time complexity:O(n+nlogk)
space complexity:O(n)
note: read about comparators throughly. other possible solutionjs using treemap+hashmap,bucket sort, quick selects are 
exists.
*/
