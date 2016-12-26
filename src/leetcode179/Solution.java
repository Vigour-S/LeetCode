package leetcode179;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xiezhuohan on 12/24/16.
 */
public class Solution {
    public String largestNumber(int[] nums) {

        String[] strings = new String[nums.length];

        for (int i=0; i<nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };

        Arrays.sort(strings, stringComparator);
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<strings.length; i++) {
            sb.append(strings[i]);
        }
        int i;
        for (i=0; i<sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                break;
            }
        }
        sb.delete(0, i);
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
