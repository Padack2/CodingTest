import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for (int t : topping) {
            map2.put(t, map2.getOrDefault(t, 0) + 1);
        }
        
        for (int t : topping) {
            map1.put(t, map1.getOrDefault(t, 0) + 1);
            int temp = map2.getOrDefault(t, 0) - 1;
            
            if (temp <= 0) {
                map2.remove(t);
            } else {
                map2.put(t, temp);
            }
            
            if (map1.size() == map2.size()) {
                answer ++;
            }
        }
        
        return answer;
    }
}