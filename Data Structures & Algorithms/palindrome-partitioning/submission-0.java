class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        backtrack(s, 0, path, result);

        return result;
    }

    private void backtrack(
        String s,
        int start,
        List<String> path,
        List<List<String>> result
    ) {
        // Base case: entire string is partitioned
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Try every possible ending index
        for (int end = start; end < s.length(); end++) {
            String substring = s.substring(start, end + 1);

            // Skip if the substring is not a palindrome
            if (!isPalindrome(substring)) {
                continue;
            }

            // Choose
            path.add(substring);

            // Explore the remaining string
            backtrack(s, end + 1, path, result);

            // Undo the choice
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
