package all_codes;

public class BinarySearch_OrderAgnostic {
    public static void main(String[] args) {
        // int[] arr = {2, 3, 5, 6, 8, 9, 10, 14, 15, 19};
        int[] arr = {25, 21, 19, 17, 15, 12, 8, 4, 1};
        int index = -1;
        int target = 8;

        if(arr[0] < arr[arr.length - 1]) {
            index = ascendingSearch(arr, target);
        } else {
            index = descendingSearch(arr, target);
        }

        System.out.println("Target found at : " + index);
    }

    private static int descendingSearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start / 2 + end / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int ascendingSearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start / 2 + end / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
