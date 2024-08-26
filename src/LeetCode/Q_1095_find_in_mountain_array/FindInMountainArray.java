package LeetCode.Q_1095_find_in_mountain_array;

interface MountainArray {
    public default int get(int index) {
        return index;
    }
    public default int length() {
        return 0;
    }
}
/*
1095. Find in Mountain Array
(This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:
arr.length >= 3

There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.
If such an index does not exist, return -1.

You cannot access the mountain array directly.
You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.
Also, any solutions that attempt to circumvent the judge will result in disqualification.

Example 1:
Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.

Example 2:
Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.


/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        if (peak == -1) return -1; // No peak found, invalid mountain array

        // Search in the increasing part
        int index = binarySearch(mountainArr, 0, peak, target, true);
        if (index != -1) return index;

        // Search in the decreasing part
        return binarySearch(mountainArr, peak + 1, mountainArr.length() - 1, target, false);
    }

    // Find the peak of the mountain array
    private int findPeak(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid; // Peak is on the left side (or mid itself)
            } else {
                start = mid + 1; // Peak is on the right side
            }
        }

        return start;
    }

    // Perform binary search in either increasing or decreasing part of the mountain array
    private int binarySearch(MountainArray mountainArr, int start, int end, int target, boolean isAscending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            int midValue = mountainArr.get(mid);

            if (midValue == target) {
                return mid;
            }

            if (isAscending) {
                if (midValue < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (midValue < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }
}
