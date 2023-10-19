import java.util.*;

class Node {
    int num;
    int attempt;

    public Node(int num, int attempt) {
        this.num = num;
        this.attempt = attempt;
    }
}

class Solution {
    public static int solution(int x, int y, int n) {
        int answer = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int num = node.num;
            int attempt = node.attempt;

            if (num == x) {
                answer = attempt;
                break;
            }

            if (num % 2 == 0) {
                queue.add(new Node(num / 2, attempt + 1));
            }
            if (num % 3 == 0) {
                queue.add(new Node(num / 3, attempt + 1));
            }
            if (num - n >= x) {
                queue.add(new Node(num - n, attempt + 1));
            }
        }

        return answer;
    }
}