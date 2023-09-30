class Solution {
  public String solution(String s) {
      String answer = "";
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      
      for(String numStr : s.split(" ")) {
          int num = Integer.parseInt(numStr);
          
          if (num > max) {
              max = num;
          }
          
          if (num < min) {
              min = num;
          }
      }
      
      return min + " " + max;
  }
}