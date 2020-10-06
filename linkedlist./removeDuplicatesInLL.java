/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        return helper(head, null);
    }
    
    ListNode helper(ListNode head, ListNode prev) {
        if (head == null)
            return head;
        
        ListNode next = head.next;
        ListNode nextNode = helper(head.next, head);
        if (prev != null && prev.val == head.val)
            return nextNode;
        
        if (next != null && next.val == head.val)
            return nextNode;
        
        head.next = nextNode;
        return head;
    }
}
/*
1 -> 1 -> 1 -> 2 ->2-> 3->4

                   
  1->2->3->3->4->4->5
                      
         
                       
                       

                       what we need to do
                           
                           
                           iterate the list
                           
                           
                           func(head, prev) {
                             if (head == null)
                               return null;
                               
                               if (prev == null)
                                 prev = head;
                                 
                              next =    func(head.next, head);
                                
                               if (prev.val == head.val || head.val == next.val)
                                 return next;
                                 
                                 head.next = next;
                              return head;
                                 
                             
                           }
               
               
               
               we need to update fast only when iterator finds no duplicates
               
               
               
               */
