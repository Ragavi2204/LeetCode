class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count = new int[26];

        // s1 characters count
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }

        // First window
        for (int i = 0; i < s1.length(); i++) {
            count[s2.charAt(i) - 'a']--;
        }

        if (allZero(count)) {
            return true;
        }

        // Sliding window
        for (int i = s1.length(); i < s2.length(); i++) {

            // Add new character
            count[s2.charAt(i) - 'a']--;

            // Remove old character
            count[s2.charAt(i - s1.length()) - 'a']++;

            if (allZero(count)) {
                return true;
            }
        }

        return false;
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