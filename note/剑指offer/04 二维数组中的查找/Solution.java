https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0; 
        int column = columns - 1;

        while (column >=0 && row < rows) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}