package DSA.Graph.CloneGraph;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    Node cloneGraph(Node node) {
        // code here

        //Manage Duplicates, new clone creation
        HashMap<Node,Node> mp= new HashMap<>();

        if (node==null)  return null;

        Queue<Node> q= new LinkedList<>();
        q.offer(node);


        //simple BFS
        mp.put(node,new Node(node.val));

        while(!q.isEmpty()){
            Node curr= q.poll();
            Node clone= mp.get(curr);

            for (Node n: curr.neighbors){
                if (mp.containsKey(n)){
                    clone.neighbors.add(mp.get(n));
                }
                else{
                    mp.put(n, new Node(n.val));
                    clone.neighbors.add(mp.get(n));
                    q.offer(n);
                }
            }
        }

        return mp.get(node);
    }
}
