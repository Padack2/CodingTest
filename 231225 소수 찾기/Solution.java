import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    int answer = 0;
    boolean[] visited;
    Set<Integer> ansNum = new HashSet<> ();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        dfs(numbers, "");
        
        answer = ansNum.stream()
            .filter(num -> isPrime(num))
            .collect(Collectors.toList())
            .size();
        
        return answer;
    }
    
    public void dfs(String numbers, String cur) {
        if (!cur.equals("")) {
            ansNum.add(Integer.parseInt(cur));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, cur + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}