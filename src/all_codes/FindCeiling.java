package all_codes;

public class FindCeiling {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 8, 10, 14, 16, 18, 20};
        int target = 24;

        System.out.println("Ceiling : " + findCeiling(arr, target));
    }

    public static int findCeiling(int[] arr, int target) {
        if(target <= arr[0]) {
            return arr[0];
        }

        if(target > arr[arr.length - 1]) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return arr[start];
    }
}
