mport java.io.*;
import java.util.*;
class Solution {

  static int[] sortKMessedArray(int[] arr, int k) {
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();
     int n = arr.length; 
  
 for (int i = 0; i < k && i < n; i++) {
    minHeap.add(arr[i]);
  }
  int current=k;
  int start=0;
  
  while(current<n){
    minHeap.add(arr[current++]);
    arr[start++]=minHeap.poll();
}
  while (!minHeap.isEmpty()) {
    arr[start++] = minHeap.poll();
  }
    return arr;
  }
  public static void main(String[] args) {
  // int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
//    sortKMessedArray(arr,2);


  }

}

*/
Test Case #1
Input:[1],0,Expected:[1].Actual:[1]
Test Case #2
Input: [1,0], 1,Expected: [0,1],Actual: [0, 1]
Test Case #3
Input: [1,0,3,2], 1,Expected: [0,1,2,3],Actual: [0, 1, 2, 3]
Test Case #4
Input: [1,0,3,2,4,5,7,6,8], 1,Expected: [0,1,2,3,4,5,6,7,8],Actual: [0, 1, 2, 3, 4, 5, 6, 7, 8]
Test Case #5
Input: [1,4,5,2,3,7,8,6,10,9], 2,Expected: [1,2,3,4,5,6,7,8,9,10],Actual: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Test Case #6
Input: [6,1,4,11,2,0,3,7,10,5,8,9], 6,Expected: [0,1,2,3,4,5,6,7,8,9,10,11],Actual: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
time complexities: (nlogk)
                    n size of input. k 
                    /*
