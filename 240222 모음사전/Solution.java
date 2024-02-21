import java.util.*;

class Solution {
    
    final String[] WORDS = {"A", "E", "I", "O", "U"};
    final int MAX_LENGTH = 5;
    int answer = 0;
        
    public int solution(String word) {
        List<String> dict = new ArrayList<>();
        
        for (String str : WORDS) {
            dfs(dict, str, word);
        }
        
        return answer;
    }
    
    void dfs(List<String> dict, String str, String word){
        if (word.equals(str)) answer = dict.size() + 1;
        if (str.length() > MAX_LENGTH || answer > 0) return;
        
        dict.add(str);
    
        for (String next : WORDS) {
            dfs(dict, str + next, word);
        }
    }
}