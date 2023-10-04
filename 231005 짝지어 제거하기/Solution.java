import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<String> stack = new Stack<String>();
        
        for(String str : s.split("")) {
            if (stack.size() > 0 && stack.peek().equals(str)) {
                stack.pop();
            } else {
                stack.push(str);
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }
}