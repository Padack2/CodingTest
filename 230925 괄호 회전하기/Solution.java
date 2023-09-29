package 230925 괄호 회전하기;

public import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1, s.length()) + s.substring(0, 1) ;
            if (validation(s)) {
                answer ++;
            }
        }
        
        return answer;
    }
    
    boolean validation(String str) {
        Stack<String> stack = new Stack<>();
        
        for (String s : str.split("")) {
            if (s.equals("{") || s.equals("(") || s.equals("[")) {
                stack.push(s);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                
                String temp = stack.pop();
                
                if ((s.equals(")") && !temp.equals("("))
                    || (s.equals("]") && !temp.equals("["))
                    || (s.equals("}") && !temp.equals("{"))) {
                    return false;
                }
            }
        }
                
        return stack.size() == 0;
    }
} Solution {
  
}
