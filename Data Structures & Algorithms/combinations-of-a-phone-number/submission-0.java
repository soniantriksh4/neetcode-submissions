

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        StringBuilder path = new StringBuilder();

        backtrack(digits, 0, phone, path, result);

        return result;
    }

    private void backtrack(
        String digits,
        int index,
        String[] phone,
        StringBuilder path,
        List<String> result
    ) {

        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = phone[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {

            path.append(letters.charAt(i));

            backtrack(digits, index + 1, phone, path, result);

            path.deleteCharAt(path.length() - 1);
        }
    }
}