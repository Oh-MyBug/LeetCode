/**
 * ClassName:   Solution_240
 * Data:        2020/8/25
 * author:      Oh_MyBug
 * version:     V1.0
 */
public class Solution_240 {
    // 二分法
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length == 0 || matrix[0].length == 0) return false;
//        for (int[] nums : matrix) {
//            if (nums[0] > target) break;
//            if (nums[nums.length - 1] < target)
//                continue;
//            if (binarySearch(nums, target))
//                return true;
//        }
//        return false;
//    }
//
//    public boolean binarySearch(int[] nums, int target) {
//        int len = nums.length;
//        int left = 0, right = len - 1;
//        while (left <= right){
//            int mid = (left + right) / 2;
//            if (nums[mid] == target) return true;
//            if (target < nums[mid])
//                right = mid - 1;
//            else
//                left = mid + 1;
//        }
//        return false;
//    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }

        return false;
    }
}
