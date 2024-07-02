class Solution {
  // 빈 병 a개를 가져다주면 콜라 b병을 주는 마트
  public int solution(int a, int b, int n) {
      int answer = 0;
      
      while (n >= 2) {
          int count = n / a * b;
          
          if (count == 0) break;
          answer += count;
          n = count + n % a;
      }
      
      
      return answer;
  }
}