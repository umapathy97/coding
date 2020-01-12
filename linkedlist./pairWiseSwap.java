//iterative
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode current=head;
        head=head.next;
        ListNode prev=null;
        while(current!=null && current.next!=null){
       /*
       point current's next to current and previous node to current next;
       previous=null.
       current=1;
       point current's next 2 to previous next. if it is null skip.
       previous becomes current.
       current skips to its next's next. 
       */
            ListNode Next = current.next;
            current.next =current.next.next;
            Next.next=current;
            if(prev!=null)
                prev.next=Next;
            prev=current;
            current=current.next;
            
        }
        return head;
    }
}
/*
time complexity:O(n)
space complexity:O(1)
*/

//recursive
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode next= head.next;
        head.next= swapPairs(head.next.next);
        next.next=head;
        return next;
    }
}
/*
beats 100% time and space
*/
