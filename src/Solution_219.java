import java.util.HashSet;
import java.util.Set;

/**
 * ClassName:   Solution_219
 * Data:        2020/8/23
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
219. 存在重复元素 II
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
示例 1:
输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:
输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:
输入: nums = [1,2,3,1,2,3], k = 2
输出: false
 */
public class Solution_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!set.add(nums[i])) return true;
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }
}
