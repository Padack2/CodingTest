import java.util.*;

class Solution {
	public int solution(int[][] jobs) {

		int answer = 0;
		int endTime = 0;
		int index = 0;
		int complete = 0; 

		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		while (complete < jobs.length) {

			while (index < jobs.length && jobs[index][0] <= endTime) {
				pq.add(jobs[index++]);
			}

			if (pq.isEmpty()) {
				endTime = jobs[index][0];
			} else {
				int[] temp = pq.poll();
				answer += temp[1] + endTime - temp[0];
				endTime += temp[1];
				complete++;
			}
            
		}

		return answer / jobs.length;
    }
}
