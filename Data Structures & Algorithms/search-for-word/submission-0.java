
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backtrack(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(
        char[][] board, String word,
        int row, int col, int index
    ) {
        // 1. All characters matched
        if (index == word.length()) {
            return true;
        }

        // 2. Out of bounds
        if (row < 0 || col < 0 ||
            row >= board.length ||
            col >= board[0].length) {
            return false;
        }

        // 3. Character mismatch
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // 4. Mark the current cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // 5. Explore down, up, right, and left
        boolean found =
            backtrack(board, word, row + 1, col, index + 1) ||
            backtrack(board, word, row - 1, col, index + 1) ||
            backtrack(board, word, row, col + 1, index + 1) ||
            backtrack(board, word, row, col - 1, index + 1);

        // 6. Restore the original character
        board[row][col] = temp;

        // 7. Return the result
        return found;
    }
}
