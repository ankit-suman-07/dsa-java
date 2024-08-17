/*
You are given an array of positive integers nums.

Alice and Bob are playing a game. In the game, Alice can choose either all single-digit numbers or
all double-digit numbers from nums, and the rest of the numbers are given to Bob.
Alice wins if the sum of her numbers is strictly greater than the sum of Bob's numbers.

Return true if Alice can win this game, otherwise, return false.

Example 1:
Input: nums = [1,2,3,4,10]
Output: false
Explanation:
Alice cannot win by choosing either single-digit or double-digit numbers.
 */

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
