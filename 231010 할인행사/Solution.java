import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();
        
        // 초기값 세팅
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        int start = 0;
        int end = 9;
        int day = 0;
        
        for (int i = 0; i < 10; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }
        
        if (checkWant(wantMap, discountMap)) day++;
        
        // discount 순회
        for (int i = 10; i < discount.length; i++) {
            int prevNum = discountMap.get(discount[start]);
            
            if (prevNum - 1 <= 0) {
                discountMap.remove(discount[start]);
            } else {
                discountMap.put(discount[start], prevNum - 1);
            }
            
            start++;
            end++;
            
            discountMap.put(discount[end], discountMap.getOrDefault(discount[end], 0) + 1);
            
            if (checkWant(wantMap, discountMap)) day++;
        }
        
        return day;
    }
    
    public boolean checkWant (Map<String, Integer> want, Map<String, Integer> discount) {
        for (String key : want.keySet()) {
            if (want.get(key) > discount.getOrDefault(key, 0)) {
                return false;
            } 
        }
        return true;
    }
}