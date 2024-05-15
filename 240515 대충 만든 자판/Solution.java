import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<> ();
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                if (map.getOrDefault(key.charAt(i), 100) > i + 1) {
                    map.put(key.charAt(i), i + 1);
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            for (int j = 0; j < target.length(); j++) {
                if (!map.containsKey(target.charAt(j))) {
                    answer[i] = -1;
                    break;
                }
                
                answer[i] += map.get(target.charAt(j));
            }
        }
        
        return answer;
    }
}