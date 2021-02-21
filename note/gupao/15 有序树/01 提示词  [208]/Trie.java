// 本质：移动current、children
class TrieNode {
    // 三样东西：1 当前node的字符串 2 children 3 是否找到了word
    //a - z
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean hasWord;

    public TrieNode() {
    
    }

    public TrieNode(char c) {
        this.c = c;
    }
    
}
public class Trie {

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        // root 就是一个空节点，没有实质的意义
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        HashMap<Character, TrieNode> children = current.children;
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < wordArray.length; i++) {
            char wc = wordArray[i];
            // 1 移动current、children
            if (!children.containsKey(wc)) {
                TrieNode newNode = new TrieNode(wc);
                children.put(wc, newNode);
                current = newNode;
            } else {
                current = children.get(wc);
            }
            // 当前字母找到了，所以到当前字母的下面去找，即当前字母的children下面找
            children = current.children;

            // 2 找到了
            if (i == wordArray.length - 1) {
                current.hasWord = true;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode current = null;
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < wordArray.length; i++) {
            // 已经有了，移动current、移动children
            if (children.containsKey(wordArray[i])) {
                current = children.get(wordArray[i]);
                children = current.children;
            } else {
                // 没有返回false
                return false;
            }
        }

        // current到了最后,即找到了，因为插入的时候最后一个hasWord是true
        if (current.hasWord){
            return true;    
        } else {
            return false;
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode current = null;
        char[] wordChar = prefix.toCharArray();
        for (int i = 0; i < wordChar.length; i++) {
            // 已经有了，移动current、children
            if (children.containsKey(wordChar[i])) {
                current = children.get(wordChar[i]);
                children = current.children;
            } else {
                return false;
            }
        }

        // 全部完了没有返回false就是true，不需要一定找到整个word
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */