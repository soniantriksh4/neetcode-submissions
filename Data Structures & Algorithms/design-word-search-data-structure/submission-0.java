class WordDictionary {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int position, TrieNode node) {
        if (position == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(position);

        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, position + 1, child)) {
                    return true;
                }
            }
            return false;
        }

        int index = ch - 'a';
        TrieNode child = node.children[index];

        if (child == null) {
            return false;
        }

        return dfs(word, position + 1, child);
    }
}