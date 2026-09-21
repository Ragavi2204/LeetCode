class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {

            int length1 = expandFromCenter(s, i, i);
            int length2 = expandFromCenter(s, i, i + 1);

            int length = Math.max(length1, length2);

            if (length > maxLength) {
                maxLength = length;

                start = i - (length - 1) / 2;
            }
        }

        return s.substring(start, start + maxLength);
    }

    private int expandFromCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }
}