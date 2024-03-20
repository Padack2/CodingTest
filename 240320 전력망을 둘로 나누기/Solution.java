import java.util.*;

class Solution {
    boolean[] visited;
    
    class Node {
        public List<Integer> connected = new ArrayList<Integer> ();
    }
    
    public int solution(int n, int[][] wires) {
        int answer = 1000;
        Node[] nodes = new Node[n + 1];
        
        for (int i = 0; i <= n; i++) {
            nodes[i] = new Node();
        }
        
        for (int[] wire : wires) {
            nodes[wire[0]].connected.add(wire[1]);
            nodes[wire[1]].connected.add(wire[0]);
        }
        
         for (int[] wire : wires) {
            answer = Math.min(answer, dfs(wire, nodes, 0, 0));   
         }
        
        return answer;
    }
    
    int dfs(int[] cutted, Node[] nodes, int cur, int cnt) {
        if (cur == 0) {
            visited = new boolean[nodes.length];
            int first = dfs(cutted, nodes, cutted[0], 0);
            visited = new boolean[nodes.length];
            int second = dfs(cutted, nodes, cutted[1], 0);
            
            return Math.abs(first - second);
        } else {
            visited[cur] = true;
            
            for (Integer next : nodes[cur].connected) {
                if ((cur == cutted[0] && next == cutted[1]) ||
                    (cur == cutted[1] && next == cutted[0]) ||
                   visited[next]) continue;
                
                cnt = dfs(cutted, nodes, next, cnt);
            }
            
            return cnt + 1;
        }
    }
}