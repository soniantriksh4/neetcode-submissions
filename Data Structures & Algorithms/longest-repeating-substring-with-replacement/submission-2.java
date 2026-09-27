class Solution {
    public int characterReplacement(String s, int k) {

        int[] count = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            // Count current character
            count[s.charAt(right) - 'A']++;

            // Find highest frequency character
            maxFreq = Math.max(
                maxFreq,
                count[s.charAt(right) - 'A']
            );

            // If replacements needed > k, shrink window
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Current window is valid
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}