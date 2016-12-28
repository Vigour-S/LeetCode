package leetcode43;

/**
 * Created by xiezhuohan on 12/27/16.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] result = new int[n1 + n2];

        for (int i = n1 - 1; i>=0; i--) {
            for (int j = n2 - 1; j>=0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = n1 - 1 - i + n2 - 1 - j;   // This line is important
                int p2 = p1 + 1;
                int add = result[p1] + mul;

                result[p1] = add % 10;
                result[p2] += add / 10;
            }
        }

        StringBuffer sb = new StringBuffer();

        for (int i = result.length - 1; i>=0; i--) {
            sb.append(result[i]);
        }

        while(sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        if (sb.length() == 0) {
            return "0";
        }

        return  sb.toString();
    }
}
