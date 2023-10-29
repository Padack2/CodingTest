class Solution {
  public int[] solution(int[] sequence, int k) {
      int[] answer = new int[2];
      int p1 = 0;
      int p2 = 0;
      int sum = sequence[0];
      int minLength = 1000001;
      
      if (sum == k) {
          answer[0] = 0;
          answer[1] = 0;
          
          return answer;
      }
      
      while (p1 <= p2) {
          if (sum <= k && p2 < sequence.length - 1) {
              p2 ++;
              sum += sequence[p2];
          } else {
              sum -= sequence[p1];
              p1 ++;
          }
          
          if (sum == k) {
              int length = p2 - p1;
              if (minLength > length) {
                  answer[0] = p1;
                  answer[1] = p2;
                  minLength = length;
              }
          }
      }
      
      return answer;
  }
}