package LeetCode.findevendigitcount;

public class FindEvenDigitCount_2 {
    public static void main(String[] args) {
        int[] nums = {23, 4, 567, 87, 1234};
        int count = 0;
        for(int num: nums) {
            // We do not need to check for any larger number as for next step,
            // the max limmit would get larger than integer values
            if((num>9 && num<100) || (num>999 && num<10000)
                    || (num>99999 && num<1000000) || (num>9999999 && num<100000000)) {
                count++;
            }
        }
        System.out.println("Number of elements with even number of digits: " + count);
    }
}
