class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows + 1][columns + 1];
        
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = num++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            int[] pos = queries[i];
            
            int[] start = {pos[0], pos[1]};
            int[] end = {pos[2], pos[3]};

            
            answer[i] = map[start[0]][start[1]];
            
            int cur = map[start[0]][start[1]];
            map[start[0]][start[1]] = map[start[0] + 1][start[1]];
            
            for (int x = start[1] + 1; x <= end[1]; x++) {
                cur = swap(map, start[0], x, cur);
                answer[i] = Math.min(cur, answer[i]);
            }
            
            for (int y = start[0] + 1; y <= end[0]; y++) {
                cur = swap(map, y, end[1], cur);
                answer[i] = Math.min(cur, answer[i]);
            }
            
            for (int x = end[1] - 1; x >= start[1]; x--) {
                cur = swap(map, end[0], x, cur);
                answer[i] = Math.min(cur, answer[i]);
            }
            
            for (int y = end[0] - 1; y >= start[0] + 1; y--) {
                cur = swap(map, y, start[1], cur);
                answer[i] = Math.min(cur, answer[i]);
            }
        }
        return answer;
    }
    
    int swap(int[][] map, int y, int x, int num) {
        int temp = map[y][x];
        map[y][x] = num;
        
        return temp;
    }
}