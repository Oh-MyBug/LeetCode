import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_228
 * Data:        2020/8/24
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
228. 汇总区间
给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
示例 1:
输入: [0,1,2,4,5,7]
输出: ["0->2","4->5","7"]
解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
示例 2:
输入: [0,2,3,4,6,8,9]
输出: ["0","2->4","6","8->9"]
解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 */
public class Solution_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) start = nums[i];
            if (i >= 1 && nums[i] != nums[i - 1] + 1) {
                helper(start, nums[i - 1], res);
                start = nums[i];
            }
            if (i == nums.length - 1){
                helper(start, nums[i], res);
            }
        }
        return res;
    }

    private void helper(int start, int end, List<String> res){
        if (start == end) {
            res.add(String.valueOf(start));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(start).append("->").append(end);
            res.add(sb.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution_228().summaryRanges(new int[]{}));
    }
}
