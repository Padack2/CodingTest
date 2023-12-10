import java.util.*;

class Solution {
    public int solution(String str1, String str2) {     
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i + 2).toUpperCase();
            if(Character.isAlphabetic(str.charAt(0))
                    && Character.isAlphabetic(str.charAt(1))){
                map1.put(str, map1.getOrDefault(str, 0) + 1);
                set.add(str);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i, i + 2).toUpperCase();
           if(Character.isAlphabetic(str.charAt(0))
                    && Character.isAlphabetic(str.charAt(1))){
                map2.put(str, map2.getOrDefault(str, 0) + 1);
                set.add(str);
            }
        }
        
        int union = 0;
        for (String s : set) {
            union += Math.max(map1.getOrDefault(s, 0), map2.getOrDefault(s, 0));
        }
        
        int intersection = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersection += Math.min(map1.get(key), map2.get(key));
            }
        }
        
        if (union == 0) return 65536;
        
        return intersection * 65536 / union ;
    }
}