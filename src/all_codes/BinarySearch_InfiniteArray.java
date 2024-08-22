package all_codes;

// Search for an item in a sorted infinite array
public class BinarySearch_InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 8, 9, 12, 14, 15, 16, 17, 20, 22, 26, 29, 30, 33, 38, 42, 44, 47, 50};
        int target = 47;
        System.out.println("Target at : ");
        System.out.println("Target at : " + search(arr, target));
    }

    static int search(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while(target > arr[end]) {

            int newStart = end + 1;
            // double the box value
            // end = previous end + size of box * 2
            end = end + (end - start + 1) * 2;

            start = newStart;

            // Checking for array index out of bounds
            if(start > arr.length) {
                return -1;
            }

            if(end > arr.length) {
                end = arr.length - 1;
            }
        }
        System.out.println("Target at : ");
        return searchInfiniteArray(arr, start, end, target);
    }

    public static int searchInfiniteArray(int[] arr, int start, int end, int target) {
        int index = -1;


        while (start <= end) {

            int mid = start + (end - start) / 2;
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
