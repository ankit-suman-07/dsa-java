package LeetCode.digit_game_can_be_won;

public class DigitGameWon_2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 10};
        int sum = 0;

        for (int num : nums) {
            sum += num<10? num : -num;
        }

        System.out.println(sum != 0);
    }

}
