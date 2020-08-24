import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:   Solution_229
 * Data:        2020/8/24
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
229. 求众数 II
给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
示例 1:
输入: [3,2,3]
输出: [3]
示例 2:
输入: [1,1,1,3,3,2,2,2]
输出: [1,2]
 */
public class Solution_229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                count++;
                if (nums[i] != nums[i - 1]) {
                    if (count > len / 3)
                        res.add(nums[i - 1]);
                    count = 0;
                }
            }
            if (i == len - 1) {
                count++;
                if (count > len / 3)
                    res.add(nums[i]);
            }
        }
        return res;
    }
}
