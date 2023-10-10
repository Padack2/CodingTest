import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<> ();
        
        for (long i = left; i <= right; i++) {
            long x = i % n;
            long y = i / n;
            
            answer.add((x > y ? (int)x : (int)y) + 1);
        }
        
        int[] arr = answer.stream().mapToInt(i -> i).toArray();
        
        return arr;
    }
}