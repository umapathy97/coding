class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fast = head;
        ListNode result=new ListNode(0);
           ListNode slow=result;
        slow.next=fast;
     //create dummynode as first node may itself a duplicate.
        while(fast!=null){    
        // move fast to current last duplicate
            while(fast.next!=null && fast.val==fast.next.val){
                fast=fast.next;
            }
            // if slow's next is not fast it indicates there is a duplicate.take slow to next non duplicate.
            // from there both slow and fast moves samely.
            if(slow.next!=fast){
                slow.next=fast.next;
            }
            else{
                slow=slow.next;
            }
            fast=fast.next;
        } 
        return result.next;
    }
}

/*
time complexity:O(n)
space complexity:O(1)
beats 78.91% time and 100% space
*/
