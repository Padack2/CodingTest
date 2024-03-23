import java.util.*;

class Solution {
    
    public static boolean numberValidation(char character) {
        return character >= 48 && character <= 57;
    }
    
    public String[] solution(String[] files) {
        Map<String, String[]> map = new HashMap<>();
        
        for (String file : files) {
            // 0: head, 1: number
            String[] strs = {"", ""};
            
            for (int i = 0; i < file.length(); i++) {
                char c = file.charAt(i);
                boolean isNumber = numberValidation(c);
                if (strs[1].equals("") && !isNumber) {
                    strs[0] += c;
                } else if (isNumber) {
                    strs[1] += c;
                } else {
                    break;
                }
            }
            
            strs[0] = strs[0].toUpperCase();

            map.put(file, strs);
        }
        
        Arrays.sort(files, (f1, f2) -> {
            int res = 0;
            String[] file1 = map.get(f1);
            String[] file2 = map.get(f2);
            
            res = file1[0].compareTo(file2[0]);
            
            if (res == 0) {
                int number1 = Integer.parseInt(file1[1]);
                int number2 = Integer.parseInt(file2[1]);
                
                res = number1 - number2;
            }
            
            return res;
        });
    
        
        return files;
    }
}