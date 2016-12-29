package leetcode316;

/**
 * Created by xiezhuohan on 12/28/16.
 */

/*
    This problem is quiet hard!
    We solve it recursively using Greedy approach
    The basic idea is to find one smallest letter each time
    We recursively do this:
    1. find the most left and smallest letter in the substring
    2. The letters behind this letter covers all unique letters in the substring
    How to determine the string we choose covers all unique letters?
    if we meet a letter which is the right most among all other same letters in the string, then the string covers all unique letters
*/

public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s==null || s.length() == 0) return "";

        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }

        int smallest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(smallest)) {
                smallest = i;
            }

            if (--letters[s.charAt(i) - 'a'] == 0) {   //this line is the key
                break;
            }
        }
        //note that we should delete the letter we have added to our result
        return s.charAt(smallest) + removeDuplicateLetters(s.substring(smallest + 1).replaceAll(s.charAt(smallest) + "", ""));
    }
}
