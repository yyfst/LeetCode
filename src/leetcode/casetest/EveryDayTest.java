package leetcode.casetest;

import leetcode.everyday.FourNumberSum;
import leetcode.everyday.ReversePairs;

public class EveryDayTest {
    private FourNumberSum fourNumberSum;
    private ReversePairs reversePairs;

    public EveryDayTest() {
        fourNumberSum = new FourNumberSum();
        reversePairs = new ReversePairs();
    }

    public void caseTest() {
        forNumberSumTest();
        reversePairsTest();
    }

    /**
     * case1:
     * input: [1,3,2,3,1]
     * output: 2
     * <p>
     * case2:
     * input: [2,4,3,5,1]
     * output: 3
     * <p>
     * test error case3:
     * input: [2147483647,2147483647,2147483647,2147483647,2147483647,2147483647]
     * output: 15
     */
    private void reversePairsTest() {
        int[] nums1 = {1, 3, 2, 3, 1};
        int[] nums3 = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        int result = reversePairs.reversePairs1(nums3);
        System.out.println("[reversePairsTest] result = " + result);
    }

    /**
     * create test for FourNumberSum
     * case1:
     * input:
     * A = [ 1, 2]
     * B = [-2,-1]
     * C = [-1, 2]
     * D = [ 0, 2]
     * output: 2
     */
    private void forNumberSumTest() {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        int result = fourNumberSum.fourSumCount(A, B, C, D);
        System.out.println("[forNumberSumTest] result = " + result);
    }
}
