class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return null;
        ListNode next = head.next;
        ListNode prev = null;
        ListNode tmp=head;
        ListNode current = head;
        // if number of remaining nodes is less than k return head;
        for(int i = 0 ; i < k; i++, tmp = tmp.next) if(tmp == null) return head;
        int count=0;
        // reverse the subgroup of linked list of size k.
        while(count<k && current!=null ){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        // next of current head should points to last element of next subgroup.
        if(next!=null)
        head.next = reverseKGroup(next,k);
        return prev;
    }
}
/*
time complexity:O(nk)
space complexity:O(n)
*/
