


public class Main
{
  Node head;
  static class Node
  {
    int data;
    Node next;
    Node prev;

      Node (int data)
    {
      this.data = data;
      next = null;
      prev = null;
    }
  }
  static Main push (int data, Main ll)
  {
    Node temp = new Node (data);
    temp.next = null;
    temp.prev = null;
    if (ll.head == null)
      ll.head = new Node (data);
    else
      {
	temp.next = ll.head;
	ll.head.prev = temp;
	ll.head = temp;
      }
    return ll;
  }
  public static void main (String args[])
  {
    Main ll = new Main ();
    ll = push (10, ll);
    ll = push (20, ll);
    ll = push (30, ll);
    while (ll.head != null)
      {
	System.out.println (ll.head.data);
	ll.head = ll.head.next;
      }

  }
}
