class Solution {
  public int solution(int n) {
      int answer = 0;
      int left = 0;
      int right = 1;
      int sum = 1;
      
      while(left < n) {
          if (sum < n) {
              right += 1;
              sum += right;
          } else {
              if (sum == n) {
                  answer ++;
              }
              left += 1;
              sum -= left;
          }
      }
      
      return answer;
  }
}