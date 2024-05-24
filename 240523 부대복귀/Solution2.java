import java.util.*;

// BFS
class Solution {
    class Node {
        public int distance;
        public int pos;
        
        public Node(int pos, int distance) {
            this.pos = pos;
            this.distance = distance;
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>> roadList = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            roadList.add(new ArrayList<Integer> ());
        }
        
        for (int[] r : roads) {
            roadList.get(r[0]).add(r[1]);
            roadList.get(r[1]).add(r[0]);
        }
        
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[destination] = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(destination, 0));
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            for (int r : roadList.get(node.pos)) {
                if (distances[r] == -1) {
                    distances[r] = node.distance + 1;
                    q.add(new Node(r, distances[r]));
                }
            }
        }

        for (int i = 0; i < sources.length; i++) {
            answer[i] = distances[sources[i]];
        }
        
        return answer;
    }
}