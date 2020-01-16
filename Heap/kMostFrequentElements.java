/*
for this solution various approach is possible.
can use hashmap and sort that hashmap. o(n+nlogn)
using hashmap and binarysearch tree(treemap) O(n+nlogn)
using hashmap and minheap )(n+nlogk)
using bucket sort O(n+n)
using quick select ( a part of quick sort partition) O(n+n)
*/
//min heap based approach
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result=new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        /*
        java comparator is used. here minheap stores each entry(key,value) of hashmap.
        it stores in sorted order
        PriorityQueue<Map.Entry<Integer,Integer>> minheap = new PriorityQueue<>((a,b)-> (a.getValue()-b.getValue()));
        for(int i=0;i<nums.length;i++){
           map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            minheap.offer(entry);
            // when inserting in minheap if heap size is greater than k, we remove smallest element from heap.
            if(minheap.size()>k)
                minheap.poll();
        }
        while(result.size()<k){
            Map.Entry<Integer,Integer>entry=minheap.poll();
            result.add(entry.getKey());
        }
        return result;
    }
    /*
    time complexity:O(n+nlogk) n for building hashmap. then for each insertion in heap takes logk.
    space complexity:O(n)
    */
}
// tree map based approach .
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //populating all numbers along with their count in hashmap.
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        /*
        we need k frequent numbers. but hashmap is not sorted.
        hence taking keys of hashmap and inserting their values in treemap.
        treemap stores elements in sorted order but for each insertion it takes O(logn) time.
         */ 
        for(int num : map.keySet()){
           int freq = map.get(num);
           if(!freqMap.containsKey(freq)){
               freqMap.put(freq, new LinkedList<>());
           }
           freqMap.get(freq).add(num);
        }
        // finally storing everything from treemap to result.
        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
}
/*
time complexity:O(n+nlogn)
space complexity:O(n+n)
*/
