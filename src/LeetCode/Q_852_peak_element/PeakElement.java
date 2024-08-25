package LeetCode.Q_852_peak_element;

/*
852. Peak Index in a Mountain Array

You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
Return the index of the peak element.
Your task is to solve it in O(log(n)) time complexity.

Example 1:
Input: arr = [0,1,0]
Output: 1

Example 2:
Input: arr = [0,2,1,0]
Output: 1

Example 3:
Input: arr = [0,10,5,2]
Output: 1
 */

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 1, 0};

        System.out.println("Peal Element : " + searchPeak(arr));
    }

    private static int searchPeak(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is a peak element
            boolean isPeak = (mid == 0 || arr[mid] >= arr[mid - 1]) &&
                    (mid == arr.length - 1 || arr[mid] >= arr[mid + 1]);

            if (isPeak) {
                return mid;
            }

            // If the element at mid is less than the element on its right,
            // then move to the right half
            if (mid < arr.length - 1 && arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
