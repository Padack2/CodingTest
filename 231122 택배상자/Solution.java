import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub = new Stack<Integer> ();
        
        int currentOrder = 1;

        while (currentOrder <= order.length || (sub.size() > 0 && sub.peek() == order[answer])) {
            if (currentOrder == order[answer]) {
                answer++;
                currentOrder++;
            } else if (sub.size() > 0 && sub.peek() == order[answer]) {
                answer++;
                sub.pop();
            } else {
                sub.push(currentOrder++);
            }
        }
        return answer;
    }
}