package leetcode350;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by xiezhuohan on 12/25/16.
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap1 = new HashMap();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for (int i=0; i<nums1.length; i++) {
            if (hashMap1.containsKey(nums1[i])) {
                hashMap1.put(nums1[i], hashMap1.get(nums1[i]) + 1);
            } else {
                hashMap1.put(nums1[i], 1);
            }
        }

        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i=0; i<nums2.length; i++) {
            if (hashMap1.containsKey(nums2[i]) && hashMap1.get(nums2[i]) != 0) {
                hashMap1.put(nums2[i], hashMap1.get(nums2[i]) - 1);
                resultList.add(nums2[i]);
            }
        }

        int[] r = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++)
        {
            r[i] = resultList.get(i);
        }
        return r;
    }
}
