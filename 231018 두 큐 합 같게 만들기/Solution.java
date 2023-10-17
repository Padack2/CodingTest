import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long q1 = 0, q2 = 0;
        
        for (int value : queue1) {
            q1 += value;
        }
        for (int value : queue2) {
            q2 += value;
        }
        
        long goal = (q1 + q2) / 2;
        
        if ((q1 + q2) % 2 == 1) return - 1;
        
        long current = q1;
        
        int[] myQueue = new int[queue1.length + queue2.length];
        System.arraycopy(queue1, 0, myQueue, 0, queue1.length);
        System.arraycopy(queue2, 0, myQueue, queue1.length, queue2.length);
        
        int left = 0;
        int right = queue1.length - 1;
        int count = 0;
        
        while (current != goal) {
            if (current < goal) {
                right ++;
                count ++;
                if (right == myQueue.length) {
                    return -1;
                } else {
                    current += myQueue[right];
                }
            } else {
                current -= myQueue[left];
                left ++;
                count ++;
            }
        }
        
        return count;
    }
}