import java.util.*;

class Solution {
    public int[] parent;
    
    public int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        else {
            return parent[a] = find(parent[a]);
        }
    }
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        int answer = 0;
        
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int weight = cost[2];
            
            int parentA = find(a);
            int parentB = find(b);
            if (parentA != parentB) {
                parent[parentB] = a;
                answer += weight;
            }
        }

        return answer;
    }
}