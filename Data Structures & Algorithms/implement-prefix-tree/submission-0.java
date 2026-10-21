class PrefixTree {
    private PrefixTree[] children = new PrefixTree[26];
    private boolean isEnd = false;

    public PrefixTree() {
    }

    public void insert(String word) {
        PrefixTree current = this;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new PrefixTree();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree node = findNode(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    private PrefixTree findNode(String text) {
        PrefixTree current = this;

        for (int i = 0; i < text.length(); i++) {
            int index = text.charAt(i) - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }
}