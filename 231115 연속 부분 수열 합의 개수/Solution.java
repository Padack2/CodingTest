import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<> ();
        
        for (int i = 0; i < elements.length; i++) {
            for (int j = 1; j <= elements.length; j++) {
                set.add(getSequence(elements, i, j));
            }    
        }
        
        return set.size();
    }
    
    int getSequence(int[] elements, int start, int length) {
        int sum = 0;
        int index = start;
        for (int i = 0; i < length; i++) {
            sum += elements[index];
            index = (index + 1) % elements.length;
        }
        
        return sum;
    }
}