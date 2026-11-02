

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, "", result);
        return result;
    }

    private void backtrack(int n, int open, int close,
                           String current, List<String> result) {

        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) {
            backtrack(n, open + 1, close, current + "(", result);
        }

        if (close < open) {
            backtrack(n, open, close + 1, current + ")", result);
        }
    }
}