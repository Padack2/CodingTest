import java.util.*;


class Huffman {
	int noe;  // the number of elements
	private int[] inputArray; // input array 


	Huffman() { 
		// Graph constructor. 
		noe = 0;
	}

	void Init(int [] arr, int n) { 
		noe = n;
		inputArray = new int[noe];
		System.arraycopy(arr, 0, inputArray, 0, n);
		System.out.print("Runs : ");
		for(int i = 0; i < noe; i++) {
			System.out.print(inputArray[i] + " ");
		}
		System.out.println();
	}

    void MergeRuns() { 
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int num : inputArray) {
            pq.add(num);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int merged = first + second;
            System.out.println("Merging " + first + " " + second);
            pq.add(merged);
        }
    }
}


