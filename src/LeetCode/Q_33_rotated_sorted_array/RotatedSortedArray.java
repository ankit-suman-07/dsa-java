package LeetCode.Q_33_rotated_sorted_array;

/*
33. Search in Rotated Sorted Array
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1
if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

 */
public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println("Found at : " + search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int peak = findPeak(nums);
        if(peak == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if(nums[peak] == target) {
            return peak;
        }

        if(target >= nums[0]) {
            return binarySearch(nums, 0, peak - 1, target);
        }


        return binarySearch(nums, peak + 1, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {

        while (start <= end) {

            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    private static int findPeak(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if(mid < end && (nums[mid] > nums[mid + 1])) {
                return mid;
            }
            if(mid > start && (nums[mid] < nums[mid - 1])) {
                return mid - 1;
            }
            if(nums[mid] <= nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return -1;
    }
}
