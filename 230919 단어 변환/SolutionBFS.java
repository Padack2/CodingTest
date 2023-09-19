import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Word{
        String str;
        int distance;
        Word(String str, int distance){
            this.str = str;
            this.distance = distance;
        }
    }
    
    boolean diffCheck(String s1, String s2){
        int cnt = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            } 
        }
        
        return cnt == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();    
        q.add(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word word = q.poll();
            if(word.str.equals(target))
                return word.distance;
            
            for(int i = 0; i < words.length; i++){
                if(diffCheck(word.str, words[i]) && !visited[i]){
                    visited[i] = true;
                    q.add(new Word(words[i], word.distance + 1));
                }
            }
        }
        
        return 0;
    }
}
