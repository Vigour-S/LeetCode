package weeklycontest14.contest476;

/**
 * Created by xiezhuohan on 1/7/17.
 */
public class Solution {
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }

        int pos = 0, temp = num, xor = 1;
        while (num > 0) {
            num = num / 2;
            pos++;
        }

        while (pos > 0) {
            xor = xor * 2 +1;
        }
        num = (temp ^ xor);

        return num;
    }
}
