package LeetCode.Q_34_first_and_last_position;

/*
34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

 */
public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 7, 7, 7, 8, 45, 67};
        int target = 7;
        int[] ans = {-1, -1};

        ans[0] = returnIndex(nums, target, true);

        if(ans[0] != -1) {
            ans[1] = returnIndex(nums, target, false);
        }

        System.out.println("Starting Index : " + ans[0]);
        System.out.println("Ending Index : " + ans[1]);
    }

    public static int returnIndex(int[] nums, int target, boolean findStartIndex) {
        int start = 0;
        int end = nums.length - 1;
        int mid;

        int ans = -1;

        while(start <= end) {
            mid = (start + end) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                if(findStartIndex) {
                    end = mid - 1;
                } else {
                    start = start + 1;
                }
            }
        }

        return ans;
    }


}
