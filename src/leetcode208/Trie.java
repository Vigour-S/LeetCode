package leetcode208;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezhuohan on 2/26/17.
 */

/*
    what is trie? See https://www.youtube.com/watch?v=AXjmTQ8LEoI
 */
public class Trie {

    class TrieNode {
        Map<Character, TrieNode> map;
        boolean endOfWord;

        public TrieNode() {
            map = new HashMap<>();
            endOfWord = false;
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.map.containsKey(c)) {
                node = node.map.get(c);
            } else {
                TrieNode temp = new TrieNode();
                node.map.put(c, temp);
                node = temp;
            }
        }
        node.endOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.map.containsKey(c)) {
                node = node.map.get(c);
            } else {
                return false;
            }
        }
        return node.endOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.map.containsKey(c)) {
                node = node.map.get(c);
            } else {
                return false;
            }
        }
        return !node.map.isEmpty() || node.endOfWord;   // be careful about this line, do not miss it self
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
