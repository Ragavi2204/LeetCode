import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<Integer> minHeap =
            new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        // Step 3: Keep only k most frequent elements
        for (int num : freq.keySet()) {

            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Create result
        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}