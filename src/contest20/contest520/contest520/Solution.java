package contest20.contest520.contest520;

/**
 * Created by xiezhuohan on 2/18/17.
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        char firstLetter = word.charAt(0);
        if (firstLetter >= 'A' && firstLetter <= 'Z') {
            if (word.length() > 2) {
                for (int i = 2; i < word.length(); i++) {
                    if (isCaptial(word.charAt(i)) != isCaptial(word.charAt(i - 1))) {
                        return false;
                    }
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (isCaptial(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCaptial(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
}
