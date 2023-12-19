import java.util.*;

class Solution {
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, (o1, o2) -> {
            return o1[1].compareTo(o2[1]);
        });
        
        for (int i = 0; i < tickets.length; i++) {
            System.out.println(tickets[i][0] +", " + tickets[i][1]);
        }

        dfs(answer, tickets, "ICN", 0);
        
        return answer;
    }
    
    void dfs(String[] answer, String[][] tickets, String current, int index) {
        if (answer[answer.length - 1] != null) return;
        
        answer[index] = current;
        
        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            if (!visited[i] && ticket[0].equals(current)) {
                visited[i] = true;
                dfs(answer, tickets, ticket[1], index + 1);
                visited[i] = false;
            }
        }
    }
}