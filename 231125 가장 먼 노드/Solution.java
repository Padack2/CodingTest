import java.util.*;

class Solution {
    class Node {
        public int id;
        public List<Integer> linkedNodes;
        public int distance = 0;
        
        Node (int id, List<Integer> linkedNodes) {
            this.id = id;
            this.linkedNodes = linkedNodes;
        }
    }
    
    public int solution(int n, int[][] edge) {
        boolean visited[] = new boolean[n];
        List<Node> nodes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i, new ArrayList<Integer>()));
        }
        
        for (int i = 0; i < edge.length; i++) {
            nodes.get(edge[i][0] - 1).linkedNodes.add(edge[i][1] - 1);
            nodes.get(edge[i][1] - 1).linkedNodes.add(edge[i][0] - 1);
        }
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(nodes.get(0));
        visited[0] = true;
        int maxDistance = 0;
        int count = 0;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            for (Integer id : current.linkedNodes) {
                if (!visited[id]) {
                    nodes.get(id).distance = current.distance + 1;
                    queue.offer(nodes.get(id));
                    visited[id] = true;
                    
                    if (nodes.get(id).distance > maxDistance) {
                        maxDistance = nodes.get(id).distance;
                        count = 1;
                    } else if (nodes.get(id).distance == maxDistance) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}