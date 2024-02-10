import java.util.*;

class Solution {
    class Point {
        public int y;
        public int x;
        
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        int[] dx = {0, 1, 0, 1};
        int[] dy = {0, 0, 1, 1};

        while (true) {
            List<Point> points = new ArrayList<Point>();
            
            // 삭제 대상 탐색
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (board[i].charAt(j) == ' ') continue;
                    
                    boolean delete = true;
                    for (int k = 1; k <= 3; k++) {
                        if (board[i].charAt(j) != board[i + dy[k]].charAt(j + dx[k])) {
                            delete = false;
                        }
                    }
                    
                    if (delete) {
                        points.add(new Point(i, j));
                    }
                }
            }
            
            // 삭제 대상 없으면 탈출
            if (points.size() == 0) break;

            boolean[][] deleted = new boolean[m][n];
            // 삭제 대상 삭제
            for (Point point : points) {
                for (int i = 0; i < 4; i++) {
                    int x = point.x + dx[i];
                    int y = point.y + dy[i];
                    if (!deleted[y][x] && board[y].charAt(x) != ' ') {
                        deleted[y][x] = true;
                        answer ++;
                        board[y] = board[y].substring(0, x) + ' ' + board[y].substring(x + 1);

                        // 삭제 후 위에 있는 열 당겨오기
                        for (int j = y; j > 0; j--) {
                            if (board[j].charAt(x) == ' ') {
                                try {
                                    board[j] = board[j].substring(0, x) + board[j - 1].charAt(x) + board[j].substring(x + 1);
                                    board[j - 1] = board[j - 1].substring(0, x) + ' ' + board[j - 1].substring(x + 1);
                                } catch (Exception e) {
                                    System.out.println(j + ", " + x);
                                }
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}