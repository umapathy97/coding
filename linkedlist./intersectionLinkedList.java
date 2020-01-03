public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1=0;
        int count2=0;
        ListNode temp=headA;
        ListNode temp2=headB;
        ListNode result=null;
        int tempvariable=0;
        while(temp!=null){
            count1++;
            temp=temp.next;
        }
        while(temp2!=null){
            count2++;
            temp2=temp2.next;
        }
       if(count1-count2>0){
           tempvariable=count1-count2;
           while(tempv>0){
               headA=headA.next;
               tempvariable--;
           }
       }
        else if(count1<count2){
            tempvariable=count2-count1;
            while(tempv>0){
                headB=headB.next;
                tempvariable--;
            }
        }
        while(headA!=null && headB!=null){
            if(headA==headB){
                result =headA;
            return result;}
            headA=headA.next;
            headB=headB.next;
        }
        return result;
    }
}
/*
time complexity:O(n)
space complexity:O(1)
beats 99% time and 5% space
*/
