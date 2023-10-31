import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            
            while (!stack.empty() && numbers[stack.peek()] < number) {
                answer[stack.pop()] = numbers[i];
            }
            
            stack.push(i);
        }
        
        return answer;
    }
}