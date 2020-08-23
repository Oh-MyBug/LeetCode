import java.util.Arrays;

/**
 * ClassName:   Solution_217
 * Data:        2020/8/23
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
217. 存在重复元素
给定一个整数数组，判断是否存在重复元素。
如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
示例 1:
输入: [1,2,3,1]
输出: true
示例 2:
输入: [1,2,3,4]
输出: false
示例 3:
输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
 */
public class Solution_217 {
    // 用 Map
//    public boolean containsDuplicate(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.get(num) != null) return true;
//            map.put(num, num);
//        }
//        return false;
//    }

    // 使用 HashSet
//    public boolean containsDuplicate(int[] nums) {
//        Set<Integer> set = new HashSet<>(nums.length);
//        for (int x : nums)
//            if (!set.add(x)) return true;
//        return false;
//    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}
