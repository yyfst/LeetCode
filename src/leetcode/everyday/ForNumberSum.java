package leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相 II
 * https://leetcode-cn.com/problems/4sum-ii/
 */
public class ForNumberSum {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                sumMap.put(sum, sumMap.getOrDefault(sum,0)+1);
            }
        }

        int result = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                if (sumMap.containsKey(-sum)) {
                    result = result + sumMap.get(-sum);
                }
            }
        }
        return result;
    }
}
