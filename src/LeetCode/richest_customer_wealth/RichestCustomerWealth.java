/*
    You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the ith customer has in the jth bank.
    Return the wealth that the richest customer has.
    A customer's wealth is the amount of money they have in all their bank accounts.
    The richest customer is the customer that has the maximum wealth.

Example 1:

Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.
 */

package LeetCode.richest_customer_wealth;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts = {{1, 5}, {3, 7}, {7, 3}};
        int max = Integer.MIN_VALUE;

        for(int[] rows: accounts) {
            int sum = 0;
            for(int col: rows) {
                sum += col;
            }
            if(sum>max) {
                max = sum;
            }
        }

        System.out.println("The max wealth is : " + max);
    }
}
