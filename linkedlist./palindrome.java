/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode ref;
    public boolean isPalindrome(ListNode head) {
        ref = head;
       return palindromehelper(head);
        
    }
     boolean palindromehelper(ListNode head) {
         if(head==null)
             return true;
      boolean ans = palindromehelper(head.next);
         boolean isnext = (head.val==ref.val)?true:false;
         ref = ref.next;
         return ans && isnext;
     }
}
