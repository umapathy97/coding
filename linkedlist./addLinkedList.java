class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        int sum=0;
        ListNode result = new ListNode(0);
        ListNode head=result;
        while(l1!=null || l2!=null){
          if(l1!=null && l2!=null){
              sum= l1.val + l2.val+carry;
          }
            else if(l1!=null)
                sum=l1.val+carry;
            else
                sum=l2.val+carry;
            if(sum>=10)
            {
                sum=sum%10;
                carry=1;
            }
            else
                carry=0;
            ListNode temp = new ListNode(sum);
            ListNode next= result.next;
            result.next=temp;
            result=result.next;
            sum=0;
           if(l1!=null)
               l1=l1.next;
            if(l2!=null)
            l2=l2.next;
        }
        if(carry!=0){
            result.next=new ListNode(carry);
            result=result.next;
        }
        return head.next;
    }
}
/*time complexity:O(n+m)
space complexity:O(n+m)
*/
