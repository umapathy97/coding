class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data=d;
        left = null;
        right = null;
    }
}
public class Main{
    Node root;
    Main(int key){
        root = new Node(key);
    }
    Main(){
        root = null;
    }
    static Node inorder(Node root){
        if(root==null)
         return null;
         inorder(root.left);
         System.out.println(root.data);
         inorder(root.right);
         return root;
    }
    public static void main(String args[]){
        Main tree = new Main();
       tree.root = new Node(100);
        tree.root.left= new Node(50);
        tree.root.right = new Node(120);
        tree.root.left.left = new Node(1009);
        inorder(tree.root);
    }
}
