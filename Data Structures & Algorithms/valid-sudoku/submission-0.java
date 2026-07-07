class Solution {

    public boolean isValidSudoku(char[][] board) {

        // Check Rows
        for (int i = 0; i < 9; i++) {

            java.util.HashSet<Character> set = new java.util.HashSet<>();

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                if (!set.add(board[i][j])) {
                    return false;
                }
            }
        }

        // Check Columns
        for (int j = 0; j < 9; j++) {

            java.util.HashSet<Character> set = new java.util.HashSet<>();

            for (int i = 0; i < 9; i++) {

                if (board[i][j] == '.') {
                    continue;
                }

                if (!set.add(board[i][j])) {
                    return false;
                }
            }
        }

        // Check 3x3 Boxes
        for (int row = 0; row < 9; row += 3) {

            for (int col = 0; col < 9; col += 3) {

                java.util.HashSet<Character> set = new java.util.HashSet<>();

                for (int i = row; i < row + 3; i++) {

                    for (int j = col; j < col + 3; j++) {

                        if (board[i][j] == '.') {
                            continue;
                        }

                        if (!set.add(board[i][j])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}