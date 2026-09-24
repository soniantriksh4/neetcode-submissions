class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        // Frequency of s1
        for (char ch : s1.toCharArray()) {
            need[ch - 'a']++;
        }

        // Sliding window
        for (int i = 0; i < s2.length(); i++) {

            window[s2.charAt(i) - 'a']++;

            // Keep window size = s1.length()
            if (i >= s1.length()) {
                window[s2.charAt(i - s1.length()) - 'a']--;
            }

            // Compare frequencies
            if (java.util.Arrays.equals(need, window)) {
                return true;
            }
        }

        return false;
    }
}