import java.util.*;
import java.util.stream.Collectors;

class Solution {
    int[] target = {1, 2, 3, 1};
    
    public int solution(int[] ingredient) {
        int answer = 0;
        if (ingredient.length < 4) return 0;
        
        List<Integer> list = Arrays.stream(ingredient)
                           .boxed()
                           .collect(Collectors.toList());
 
        for (int i = 0; i < list.size() - 3; i++) {
            if (list.get(i) == 1) {
                if (checkBurger(list, i)) {
                    answer++;
                    i = Math.max(-1, i - 3);
                    
                }
            }
        }
        
        return answer;
    }
    
    public boolean checkBurger(List<Integer> ingredient, int idx) {
        int count = 1;
        int index = idx;
        int[] usedIndex = {idx, 0, 0, 0};
        while(count < 4) {
            index ++;
            
            if (index >= ingredient.size()) return false;
            
            if (ingredient.get(index) == target[count]) {
                usedIndex[count] = index;
                count ++;
            } else {
                return false;
            }
        }
        
        for (int i = 3; i >= 0; i--) {
            ingredient.remove(usedIndex[i]);
        }
        
        return true;
    }
}