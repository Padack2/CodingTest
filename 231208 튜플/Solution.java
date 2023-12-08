import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr1;
        String[][] arr2;
        
        s = s.substring(2, s.length() - 2);
        arr1 = s.split("\\},\\{");
        arr2 = new String[arr1.length][];
        
        
        for (int i = 0; i < arr1.length; i++) {
            String[] temp = arr1[i].split(",");
            arr2[temp.length - 1] = temp;
        }

        Set<String> set = new LinkedHashSet<>();
        
        for (String[] arr : arr2) {
            for (String t : arr) {
                set.add(t);
            }
        }
        
        int[] answer = new int[set.size()];
        int i = 0;
        for (String t : set) {
            answer[i++] = Integer.parseInt(t);
        }
        
        
        return answer;
    }
}