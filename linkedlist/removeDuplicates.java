class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      
        ListNode fast=head;
          ListNode slow=fast;
          // move fast pointer to end of last duplicate
        while(fast!=null){
            while(fast.next!=null && fast.val==fast.next.val)
                fast=fast.next;
                // if both fast and slow not same then there is duplicate
                // move next of slow to point to fast's next.
            if(slow!=fast){
                slow.next=fast.next;
            }
            // move slow every time
                slow=slow.next;
                fast=fast.next;
            
        }
        return head;
    }
}
/* time complexity:O(n)
    space complexity:O(1)
    beats 100% space and time.
    */
    
    
   // alternate clear solution:
    public ListNode deleteDuplicates1(ListNode head) {
    ListNode p = head;
    while (p != null && p.next != null) {
        if (p.val == p.next.val) {
            p.next = p.next.next;
        } else {
            p = p.next;
        }
    }
    return head;
}
