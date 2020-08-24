/**
 * ClassName:   Solution_240
 * Data:        2020/8/25
 * author:      Oh_MyBug
 * version:     V1.0
 */
public class Solution_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            if (binarySearch(nums, target))
                return true;
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_240().binarySearch(new int[]{1, 4, 7, 11, 15}, -1));
    }
}
