import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<String> pq = new PriorityQueue<> ((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2) * -1;
            } else {
                int cal1 = Integer.parseInt(o1 + o2);
                int cal2 = Integer.parseInt(o2 + o1);
                
                return cal2 - cal1;
            }
        });
        
        for (int i = 0; i < numbers.length; i++) {
            pq.add(String.valueOf(numbers[i]));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (pq.size() > 0) {
            sb.append(pq.poll());
        }
        
        answer = sb.toString();
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) != '0') {
                answer = answer.substring(i);
                break;
            }
            if (i == answer.length() - 1) {
                answer = "0";
            }
        }
        
        return answer;
    }
}