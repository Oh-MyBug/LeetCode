import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_216
 * Data:        2020/8/23
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
216. 组合总和 III
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
说明：
所有数字都是正整数。
解集不能包含重复的组合。 
示例 1:
输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:
输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        helper(k, n, 0, 0, 0, res, new ArrayList<>());
        return res;
    }

    public void helper(int k, int n, int count, int cur, int sum, List<List<Integer>> res, List<Integer> temp){
        if (sum == n && count == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        if (count == k || sum == n) return;
        for (int i = cur + 1; i <= 9; i++) {
            if (k - count > 10 - i) break;
            temp.add(i);
            helper(k, n, count + 1, i, sum + i, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
