package leetcode482;

/**
 * Created by xiezhuohan on 2/25/17.
 */
public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = sb.length() - 1; i >= 0;) {
            int count = 0;
            while (count != K) {
                char ch = sb.charAt(i);
                if (ch != '-') {
                    if (ch >= 'a' && ch <= 'z') {
                        sb.insert(i, Character.toUpperCase(ch));
                        sb.deleteCharAt(i + 1);
                    }
                    count++;
                } else {
                    sb.deleteCharAt(i);
                }
                i--;
                if (i < 0) {
                    return sb.toString();
                }
            }
            sb.insert(i + 1, '-');
            int temp = i;
            while (temp >= 0) {
                if (sb.charAt(temp) != '-') {
                    break;
                }
                temp--;
            }
            if (temp == -1) {
                temp++;
                while(sb.charAt(temp) == '-') {
                    sb.deleteCharAt(temp);
                    temp++;
                }
            }
        }
        return sb.toString();
    }
}
