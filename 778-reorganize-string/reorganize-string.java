import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        while (pq.size() > 1) {
            int[] first = pq.poll();
            int[] second = pq.poll();

            result.append((char) (first[0] + 'a'));
            result.append((char) (second[0] + 'a'));

            first[1]--;
            second[1]--;

            if (first[1] > 0) {
                pq.offer(first);
            }

            if (second[1] > 0) {
                pq.offer(second);
            }
        }

        if (!pq.isEmpty()) {
            int[] last = pq.poll();

            if (last[1] > 1) {
                return "";
            }

            if (result.length() > 0 &&
                result.charAt(result.length() - 1) == (char) (last[0] + 'a')) {
                return "";
            }

            result.append((char) (last[0] + 'a'));
        }

        return result.toString();
    }
}