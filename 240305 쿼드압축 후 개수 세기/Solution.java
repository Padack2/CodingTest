class Solution {
    int[] answer = new int[2];

    class Point {
        public int y;
        public int x;
        
        public Point (int x, int y) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int[] solution(int[][] arr) {
        getQuad(arr, new Point(0, 0), arr.length);
        return answer;
    }
    
    boolean validation(int[][] arr, Point pos, int size) {
        int value = arr[pos.y][pos.x];

        for (int i = pos.y; i < pos.y + size; i++) {
            for (int j = pos.x; j < pos.x + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    void getQuad(int[][] arr, Point pos, int size) {
        if (validation(arr, pos, size)) {
            answer[arr[pos.y][pos.x]]++;
        } else {
            int newSize = size / 2;
            getQuad(arr, pos, newSize);
            getQuad(arr, new Point(pos.x, pos.y + newSize), newSize);
            getQuad(arr, new Point(pos.x + newSize, pos.y), newSize);
            getQuad(arr, new Point(pos.x + newSize, pos.y + newSize), newSize);
        }
    }
}