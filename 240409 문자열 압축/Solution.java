import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1; i < s.length(); i++) {
            int start = 0;
            
            String prev = "";
            int repeat = 1;
            int count = 0;
            StringBuilder sb = new StringBuilder("");
            while (start < s.length()) {
                int end = Math.min(start + i, s.length());
                String key = s.substring(start, end);
                
                if (prev.equals(key)) {
                    repeat ++;
                } else {
                    if (repeat > 1) {
                        count += (int) Math.log10(repeat) + 1;
                        repeat = 1;
                    }
                    count += key.length();
                    sb.append(key);
                }
                prev = key;
                start += i;
            }
            
            if (repeat > 1) {
                count += (int) Math.log10(repeat) + 1;
            }
    
            answer = Math.min(answer, count);
        }
        
        return answer;
    }
}