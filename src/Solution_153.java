/**
 * ClassName:   Solution_153
 * Data:        2020/8/16
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
153. 寻找旋转排序数组中的最小值
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
请找出其中最小的元素。
你可以假设数组中不存在重复元素。
示例 1:
输入: [3,4,5,1,2]
输出: 1
示例 2:
输入: [4,5,6,7,0,1,2]
输出: 0
 */
public class Solution_153 {
    /*
    歪门邪道
    public int findMin(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        }
        return nums[0];
    }*/

    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[0])
            return nums[0];
        while (right >= left) {
            int mid = (right + left) / 2;
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if (nums[mid - 1] > nums[mid])
                return nums[mid];
            if (nums[mid] > nums[0])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
