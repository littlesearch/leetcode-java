package 字典树;

/**
 * @Auther: Jesper
 * @Date: 2019/1/9 18:12
 * @Description: 实现 Trie (前缀树)
 */
public class Trie_208 {

    class TrieNode {
        public char val;
        public boolean isWord;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }

        TrieNode(char c) {
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */

    public Trie_208() {
        root = new TrieNode();
        root.val = ' ';
    }


    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
}
