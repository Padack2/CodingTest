import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<String> cache = new ArrayList<>();
                
        int answer = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.contains(city)) {
                answer += 1;
                cache.remove(city);
            } else {
                answer += 5;
            }
            
            cache.add(city);
            
            if (cache.size() > cacheSize) {
                cache.remove(0);
            }
        }

        return answer;
    }
}