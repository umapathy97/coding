/*
APPROACH:
Use Queue for level order Traversal
Use treeMap for storing key value pair in sorted order
Entry set for iterating and printing the result.
QueueObj class to store node and it's distance.

Intution:  Until queue is empty for each node if it's distance not in treemap add it's distance as key and node as value. add it's left child queueobj(lift child node, current distance-1) to queue.
           add right child queueobj(right child node,current distance +1) is not null. 
           */
    
	public static void topView(Node root) {
       class QueueObj { 
            Node node; 
            int height; 
  
            QueueObj(Node node, int height) { 
                this.node = node; 
                this.height = height; 
            } 
        }
      TreeMap<Integer,Node> map = new TreeMap<>();
        Queue<QueueObj> q = new LinkedList<QueueObj>();
           if (root == null) { 
            return; 
        } else { 
            q.add(new QueueObj(root, 0)); 
        } 
         while(!q.isEmpty()){
             QueueObj temp = q.poll();
             if(!map.containsKey(temp.height)){
                 map.put(temp.height,temp.node);
             }
             if(temp.node.left!=null){
                 q.add(new QueueObj(temp.node.left,temp.height-1));
             }
              if(temp.node.right!=null){
                 q.add(new QueueObj(temp.node.right,temp.height+1));
             }
               
        }
        for (Map.Entry<Integer, Node> entry : map.entrySet()) { 
            System.out.print(entry.getValue().data + " " ); 
        } 


    }
    /*
    time complexity:O(n)
    Space complexity:O(n+n)
read question from:https://www.hackerrank.com/challenges/tree-top-view/problem
reference:https://www.youtube.com/watch?v=cfe0coRWjqc

