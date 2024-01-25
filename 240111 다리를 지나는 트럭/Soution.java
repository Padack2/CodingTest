import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0, answer = 0, index = 0;

        while (index < truck_weights.length) {
            if (q.size() == bridge_length) {
                sum -= q.poll();
            }

            if (sum + truck_weights[index] <= weight) {
                q.offer(truck_weights[index]);
                sum += truck_weights[index];
                index++;
            } else {
                q.offer(0);
            }

            answer++;
        }

        return answer + bridge_length;
    }
}