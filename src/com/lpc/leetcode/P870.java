package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 优势洗牌
 *
 * @author byu_rself
 * @date 2022/10/8 15:55
 */
public class P870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int length = nums1.length;
        Arrays.sort(nums1);
        Integer[] index = new Integer[length];
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) index[i] = i;
        Arrays.sort(index, (a, b) -> nums2[a] - nums2[b]);
        int l = 0, r = length - 1;
        for (int num : nums1) {
            ans[num > nums2[index[l]] ? index[l++] : index[r--]] = num;
        }
        return ans;
    }
}
