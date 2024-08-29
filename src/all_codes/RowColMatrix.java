package all_codes;

/*
Search for an element in a matrix where it is sorted row-wise and column-wise
 */
public class RowColMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 4, 6, 7},
                {5, 7, 12, 14, 15},
                {9, 10, 14, 17, 21}
        };

        int target = 12;
        int[] answer = search(matrix, target);
        System.out.println(answer[0] + ", " +  answer[1]);
    }

    static int[] search(int[][] matrix, int target) {
        int r = 0;
        int c = matrix.length - 1;

        while(r < matrix.length && c >= 0) {
            if(matrix[r][c] == target) {
                return new  int[]{r, c};
            }
            if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return new  int[]{-1, -1};
    }
}
