import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {-1, -1};
        
        Set<String> set = new HashSet<> (List.of(gems));
        Map<String, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        
        map.put(gems[0], 1);
        
        if (map.size() == set.size()) {
            answer[0] = 0;
            answer[1] = 0;
        }

        while (start != gems.length) {
            if (map.size() == set.size() || end == gems.length - 1) {
                int temp = map.getOrDefault(gems[start], 0) - 1;
                if (temp <= 0) {
                    map.remove(gems[start]);
                } else {
                    map.put(gems[start], temp);
                }
                start ++;
            } else {
                end ++;
                int temp = map.getOrDefault(gems[end], 0) + 1;
                map.put(gems[end], temp);
            }
            
            if (map.size() == set.size()) {
                if (answer[1] == -1 ||
                    answer[1] - answer[0] > end - start) {
                    answer[0] = start;
                    answer[1] = end;
                }
            }
        }
        
        answer[1] += 1;
        answer[0] += 1;

        return answer;
    }
}