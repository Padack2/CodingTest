import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<> ();
        
        char alpha = 'A';
        
        for (int i = 1; i <= 26; i++) {
            dict.put(String.valueOf(alpha++), i);
        }
        
        int cur = 0;
        String key = "";
        int length = 27;

        while (cur < msg.length()) {
            key += msg.charAt(cur++);
            
            if (cur == msg.length()) {
                if (dict.containsKey(key)) {
                    answer.add(dict.get(key));
                } else {
                    answer.add(length);
                }
            } else if (!dict.containsKey(key + msg.charAt(cur))) {
                answer.add(dict.get(key));
                dict.put(key + msg.charAt(cur), length++);
                key = "";
            }
        }
        
        int[] answerArr = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerArr[i] = answer.get(i);
        }
        
        return answerArr;
    }
}