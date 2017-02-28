package leetcode211;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiezhuohan on 2/26/17.
 */

/*
    Similar to #208
 */
public class WordDictionary {

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
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, root);
    }

    public boolean helper(String word, TrieNode node) {
        if (word == null || word.length() == 0) {
            return node.endOfWord;
        }
        char ch = word.charAt(0);
        if (node.map.containsKey(ch)) {
            return helper(word.substring(1), node.map.get(ch));
        } else if (ch == '.') {
            for (TrieNode temp : node.map.values()) {
                if (helper(word.substring(1), temp)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
