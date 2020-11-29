package leetcode.everyday;

/**
 * 493. 翻转对
 * https://leetcode-cn.com/problems/reverse-pairs/
 */
public class ReversePairs {
    /**
     * Violent search
     * error: time out
     *
     * @param nums input
     * @return result
     */
    public int reversePairs1(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long tmp1 = nums[i];
                long tmp2 = 2 * (long) nums[j];
                result = tmp1 > tmp2 ? (result + 1) : result;
            }
        }
        return result;
    }

    /**
     * Merging algorithm
     *
     * @param nums input
     * @return result
     */
    public int reversePairs2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        return sort(nums, 0, nums.length - 1);
    }

    private int sort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int res1 = sort(nums, left, mid);
        int res2 = sort(nums, mid + 1, right);
        int res3 = merge(nums, left, mid, right);
        return res1 + res2 + res3;
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int res = 0;

        /**
         *
         */
        /*
         * nums数组根据left mid right分为左右两数组，即：
         * nums[left,mid],nums[mid,right]
         *
         */
        while (i <= mid && j <= right) {
            if (nums[i] > 2 * (long) nums[j]) {
                j++;
                res += mid + 1 - i;
            } else {
                i++;
            }
        }

        i = left;
        j = mid + 1;
        int[] tmp = new int[right - left + 1];
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }

        for (int index = 0; index < tmp.length; index++) {
            nums[left + index] = tmp[index];
        }
        return res;
    }
}











