import java.util.*;

class Solution {
    class Date {
        public int year;
        public int month;
        public int day;
        
        public Date(String date) {
            String[] strs = date.split("\\.");

            year = Integer.parseInt(strs[0]);
            month = Integer.parseInt(strs[1]);
            day = Integer.parseInt(strs[2]);
        }
    }
    
    public boolean expiredCheck(Date today, Date privacy, int term) {
        int remain = 0;
        
        int day = today.day - privacy.day;
        if (day < 0) {
            remain = -1;
            day += 28;
        }
        
        int month = today.month - privacy.month + remain;
        remain = 0;
        if (month <= 0) {
            remain = -1;
            month += 12;
        }
        
        int year = today.year - privacy.year + remain;
        int result = year * 12 + month;
        
        return term <= result;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        
        Date todayDate = new Date(today);
        Map<String, Integer> termsMap = new HashMap<>();
        
        for (String term : terms) {
            String[] temp = term.split(" ");
            termsMap.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            Date privacy = new Date(temp[0]);
            int term = termsMap.get(temp[1]);
            
            if (expiredCheck(todayDate, privacy, term)) {
                answerList.add(i + 1);
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}