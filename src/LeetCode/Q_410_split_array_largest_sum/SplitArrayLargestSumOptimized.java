package LeetCode.Q_410_split_array_largest_sum;

/*
410. Split Array Largest Sum
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum
of any subarray is minimized.

Return the minimized largest sum of the split.
A subarray is a contiguous part of the array.

Example 1:
Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

Example 2:
Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

 */
public class SplitArrayLargestSumOptimized {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }
    public static int splitArray(int[] nums, int k) {
        int max = 0;
        int sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int left = max, right = sum;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canSplit(int[] nums, int k, int maxSum) {
        int sum = 0, pieces = 1;
        for (int num : nums) {
            if (sum + num > maxSum) {
                sum = num;
                pieces++;
                if (pieces > k) {
                    return false;
                }
            } else {
                sum += num;
            }
        }
        return true;
    }
}

