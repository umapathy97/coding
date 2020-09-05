Find the first non-repeating character from a stream of characters
Last Updated: 18-05-2020
Given a stream of characters, find the first non-repeating character from stream. You need to tell the first non-repeating character in O(1) time at any moment.


import java.util.*;
public class Solution {
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
     // add each character to stream
     void add(int num) {
           map.put(num, map.getOrDefault(num, 0) + 1);
      }


      // get non repeating character
      int getNonRepeatingCharacter() {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
		if (entry.getValue() == 1)
			return entry.getKey();
            }
            return -1;
      }

     public static void main(String args[]) {
         Solution sol = new Solution();
         sol.add(2);
         sol.add(3);
         sol.add(2);
         sol.add(4);

         System.out.println(sol.getNonRepeatingCharacter());
     }
}
