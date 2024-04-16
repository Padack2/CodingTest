import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] correct = {0, 0, 0};
        int[][] rules = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < rules.length; j++) {
                int[] rule = rules[j];
                if (rule[i % rule.length] == answers[i]) {
                    correct[j] ++;
                }
            }
        }
        
        int max = 0;

        for (int num : correct) {
            max = Math.max(max, num);            
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (max == correct[i]) {
                result.add(i + 1);
            }
        }
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}