package LeetCode.findevendigitcount;

public class FindEvenDigitCount {
    public static void main(String[] args) {
        int[] nums = {23, 4, 567, 87, 1234};
        int count = 0;
        for(int num: nums) {
            if(findEven(num)%2 == 0) {
                count++;
            }
        }
        System.out.println("Number of elements with even number of digits: " + count);
    }

    // Math.log10(num) in Java calculates the base-10 logarithm of the number num.
    // This function returns the power to which the number 10 must be raised to obtain the given number.

    // Let take 1234 as an example
    // Step 1: Math.log10(1234) returns approximately 3.0913.
    // Step 2: (int) Math.log10(1234) converts it to 3.
    // Step 3: Adding 1 results in 4, which is the number of digits in 1234.
    private static int findEven(int num) {
        return (int)(Math.log10(num)) + 1;
    }
}
