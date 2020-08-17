/**
 * ClassName:   Solution_169
 * Data:        2020/8/17
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例 1:
输入: [3,2,3]
输出: 3
示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2
 */
public class Solution_169 {
    /*public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        if (len == 1) return nums[0];
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer != null){
                map.put(num, integer + 1);
                if (integer >  len / 2 - 1)
                    return num;
            } else {
                map.put(num, 1);
            }
        }
        return 0;
    }

    // 下流法
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }*/

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_169().majorityElement(new int[]{3, 2, 3}));
    }
}
