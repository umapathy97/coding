public class LinkedList{
    Node head;
     class Node{
         int data;
         Node next;
         Node(int x){
             data = x;
             next = null;
         }
     }
     LinkedList insert(LinkedList l,int data){
         Node temp = new Node(data);
         if(l.head==null)
            head=temp;
            else
            {
                temp.next=head;
                head = temp;
            }
            return l;
     }
    Node findmid(Node root){
         Node slow = root;
         Node fast = root;
         while(fast!=null && fast.next!=null){
             slow=slow.next;
             fast=fast.next.next;
         }
         return slow;
     }
     public static void main(String args[]){
         LinkedList l = new LinkedList();
       l=  l.insert(l,3);
        l= l.insert(l,5);
        l = l.insert(l,12);
        l= l.insert(l,10);
         l= l.insert(l,15);
      Node mid =  l.findmid(l.head);
      System.out.println(mid.data);
        
     }
}
