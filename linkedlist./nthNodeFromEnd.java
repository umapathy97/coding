/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        //create a new node start
        ListNode slow = start;
        ListNode fast = start;
        slow.next=head;
        start.next=head;
        if(head==null)
            return null;
            // move fast pointer to n+1 nodes ahead
        for(int i=1;i<=n+1;i++)
         fast=fast.next;
         // now there are n nodes between slow and fast pointers.
         //move both pointers equaly at a time
        while(fast!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        // delete nth node . by setting slow.next=slow.next.next we are deleting slow.next
     slow.next= slow.next.next;
        return start.next;
    }
}
/* time complexity : O(n) traditional two pointers approach with only one pass
space complexity:O(1) no extra space is used
*/
