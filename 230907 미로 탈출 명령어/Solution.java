import java.util.*;

class Solution {
    List<String> answers;
    String answer = "";
        
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "";
        answers = new ArrayList<String> ();
        getAnswer("", n, m, x, y, r, c, k, 0);
        
        if (answer.equals("")) {
            answer = "impossible";
        }
        
        return answer;
    }
    
    public void getAnswer(String path, int n, int m, int currentX, int currentY, int r, int c, int k, int j) {    
        if (answer.length() > 0) {
            return;
        }
        
        if (currentX == r && currentY == c && j == k) {
            answer = path;
            return;
        }
        
        if (j > k) {
            return;
        }
        int distance = Math.abs(r - currentX) + Math.abs(c - currentY);
        if (distance > k - j || distance % 2 != (k - j) % 2) {
            return;
        }
        
        if (currentX != n) {
            getAnswer(path + "d", n, m, currentX + 1, currentY, r, c, k, j + 1);
        }
        if (currentY != 1) {
            getAnswer(path + "l", n, m, currentX, currentY - 1, r, c, k, j + 1);
        }
        if (currentY != m) {
            getAnswer(path + "r", n, m, currentX, currentY + 1, r, c, k, j + 1);
        }
        if (currentX != 1) {
            getAnswer(path + "u", n, m, currentX - 1, currentY, r, c, k, j + 1);
        }
    }
}