package LeetCode.digit_game_can_be_won;

public class DigitGameWon {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 10};
        int one = 0;
        int two = 0;

        for(int num: nums) {
            if(num < 10) {
                one += num;
            } else{
                two += num;
            }
        }

        System.out.println(one != two);
    }

}
