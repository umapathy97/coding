class Solution {
	public Node cloneGraph(Node node) {
  if (node == null) return null;
  
  // use a queue to help BFS
  Queue<Node> queue = new LinkedList<Node>();
  queue.add(node);
  
  // use a map to save cloned nodes
  Map<Node, Node> map = new HashMap<>();
  
  // clone the root
  map.put(node, new Node(node.val,new ArrayList<>()));
  
  while (!queue.isEmpty()) {
    Node nod = queue.poll();
    
    // handle the neighbors
    for (Node neighbor : nod.neighbors) {
      if (!map.containsKey(neighbor)) {
        // clone the neighbor
        map.put(neighbor, new Node(neighbor.val,new ArrayList<>()));
        // add it to the next level
        queue.add(neighbor);
      }
      
      // copy the neighbor
      map.get(nod).neighbors.add(map.get(neighbor));
    }
  }
  
  return map.get(node);
}
}
/*
time complexity:O(|v| + |E|)
space complexity:(O(|v|)
*/
