package LeetCode.Q_744_find_ceiling_character;

/*
https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

744. Find Smallest Letter Greater Than Target
You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
There are at least two different characters in letters.
Return the smallest character in letters that is lexicographically greater than target.
If such a character does not exist, return the first character in letters.

Example 1:

Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
Example 2:

Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
 */
public class FindCeilingChar {
    public static void main(String[] args) {
        char[] letters = {'c', 'e', 'f'};
        char target = 'c';
        System.out.println("Ceiling character : " + nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        if(target > letters[letters.length - 1] || target < letters[0]) {
            return letters[0];
        }

        int start = 0;
        int end = letters.length - 1;
        int mid;

        while(start <= end) {

            mid = (end + start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start%letters.length];
    }
}
