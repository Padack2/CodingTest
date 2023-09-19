import java.util.*;

class Solution {
    
    boolean[] visited;
    int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        boolean exist = false;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                exist = true;
            }
        }
        
        if (exist) {
            visited = new boolean[words.length];
            dfs(0, begin, target, words);
            
            return answer;
        }
        
        return 0;
    }
    
    void dfs(int count, String begin, String target, String[] words) {
        if (begin.equals(target) && answer > count) {
            answer = count;
            return;
        }
        
        if (count >= answer) return;
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && diffCheck(words[i], begin)) {
                visited[i] = true;
                dfs(count + 1, words[i], target, words);
                visited[i] = false;
            }
        }
    }
    
    boolean diffCheck(String s1, String s2) {
        int cnt = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            } 
        }
        
        return cnt == 1;
    }
}

