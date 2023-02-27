package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 通过最少操作次数使数组的和相等
 *
 * @author byu_rself
 * @date 2023/2/27 13:39
 */
public class P1775 {

    public int minOperations(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (6 * m < n || 6 * n < m) return -1;
        int d = Arrays.stream(nums2).sum() - Arrays.stream(nums1).sum();
        if (d < 0) {
            d = -d;
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int[] cnt = new int[6];
        for (int num : nums1) ++cnt[6 - num];
        for (int num : nums2) ++cnt[num - 1];
        int ans = 0;
        for (int i = 5; ; i--) {
            if (i * cnt[i] >= d) {
                return ans + (d + i - 1) / i;
            }
            ans += cnt[i];
            d -= i * cnt[i];
        }
    }
}
