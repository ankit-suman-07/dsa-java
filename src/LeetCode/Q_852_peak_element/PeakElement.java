package LeetCode.Q_852_peak_element;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0};

        System.out.println("Peal Element : " + searchPeak(arr));
    }

    private static int searchPeak(int[] arr) {
        if(arr.length == 1) {
            return 0;
        }

        if(arr.length == 2) {
            return arr[0] > arr[1] ? 0 : 1;
        }

        int start = 0;
        int end = arr.length - 1;
        int mid = end + (end - start) / 2;

        while(arr[mid] < arr[start] || arr[mid] < arr[end]) {
            mid = end + (end - start) / 2;
            if(arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
                return mid;
            }
            if(arr[start] > arr[mid]) {

            }
        }
    }
}
