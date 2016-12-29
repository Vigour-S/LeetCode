package leetcode10;

/**
 * Created by xiezhuohan on 12/28/16.
 */

// This problem is very difficult
// many conditions to be considered
    // we should mainly consider to conditions:
    // 1. corresponding character in p is not "*"
    // In this case, there are two small cases:
        // 1.1 corresponding character is ".", then it will match any character, move on
        // 1.2 simply compare the characters, if the same, move on
    // 2. Next character in p is "*"
    // This case is quite complicated. if p[j+1] is "*", it means all characters behind s[i] will be the possible match
    // So we should try each of them
public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s,p,0,0);
    }
    private boolean helper(String s, String p, int i, int j)
    {
        if(j==p.length())
            return i==s.length();

        if(j==p.length()-1 || p.charAt(j+1)!='*')
        {
            if(i==s.length()|| s.charAt(i)!=p.charAt(j) && p.charAt(j)!='.')
                return false;
            else
                return helper(s,p,i+1,j+1);
        }
        //p.charAt(j+1)=='*'
        while(i<s.length() && (p.charAt(j)=='.' || s.charAt(i)==p.charAt(j)))
        {
            if(helper(s,p,i,j+2))   // this case is when "*" matches with nothing
                return true;
            i++;
        }
        return helper(s,p,i,j+2);
    }
}
