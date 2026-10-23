

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Step 1: Insert all words into Trie
        for (String word : words) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }

            current.word = word;
        }

        // Step 2: Start DFS from every cell
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {

        // Boundary check
        if (r < 0 || c < 0 ||
            r >= board.length || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        // Already visited or prefix doesn't exist
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];

        // Found a complete word
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicate results
        }

        // Mark current cell as visited
        board[r][c] = '#';

        // Explore four directions
        dfs(board, r + 1, c, node); // Down
        dfs(board, r - 1, c, node); // Up
        dfs(board, r, c + 1, node); // Right
        dfs(board, r, c - 1, node); // Left

        // Backtrack: restore original character
        board[r][c] = ch;
    }
}