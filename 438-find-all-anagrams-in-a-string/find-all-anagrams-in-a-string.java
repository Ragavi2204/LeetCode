import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] count = new int[26];

        // Count characters in p
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }

        // First window
        for (int i = 0; i < p.length(); i++) {
            count[s.charAt(i) - 'a']--;
        }

        if (allZero(count)) {
            result.add(0);
        }

        // Sliding window
        for (int i = p.length(); i < s.length(); i++) {

            // Add new character
            count[s.charAt(i) - 'a']--;

            // Remove old character
            count[s.charAt(i - p.length()) - 'a']++;

            if (allZero(count)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    private boolean allZero(int[] count) {

        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}