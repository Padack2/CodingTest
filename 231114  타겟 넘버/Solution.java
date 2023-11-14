class Solution {
  int answer = 0;
  
  public int solution(int[] numbers, int target) {
      dfs(numbers, target, 0, 0);
      return answer;
  }
  
  void dfs(int[] numbers, int target, int index, int sum) {
      if (index == numbers.length && target == sum) {
          answer ++;
      }
      if (index >= numbers.length) {
          return;
      }
      
      dfs(numbers, target, index + 1, sum + numbers[index]);
      dfs(numbers, target, index + 1, sum - numbers[index]);
  }
}