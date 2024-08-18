package all_codes;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 12, 23, 444, 4567, 5678};
        System.out.println("Target found at: " + findIndex(arr, 4567));
    }

    public static int findIndex(int[] arr, int target) {
        int index = -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // int mid = (start + end) / 2;
            // In some cases start and end could be very large integers
            // And adding those might exceed the max range of int.
            // In that case the above calculation will give an error
            // this can also be written as start + (start - end) / 2
            int mid = start / 2 + end / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return index;
    }
}
