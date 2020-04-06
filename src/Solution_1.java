import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Objects;

/**
 * ClassName: Solution_1
 * Date:      2020/4/6 9:51
 * author:    Oh_MyBug
 * version:   V1.0
 */
/*
1. 两数之和
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的
那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
示例:
    给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
public class Solution_1 {
    @Test
    public void test(){
        int[] nums = {3,3};
        System.out.println(twoSum(nums, 6)[0] + " " + twoSum(nums, 6)[1]);
    }
    /**
     * 将nums数组存入HashMap map中,key为nums数值，value为index
     * ① 存入过程中如果出现之前已存入相同nums数值的状况，判断相同nums数值相加是否为target，
     *    若是，则直接返回这两个nums数值的index
     * ② 存入结束后，再次循环遍历nums数组，判断target-nums[i]是否存在，若存在，则返回nums[i]和
     *    target-nums[i]的index；若不存在，则继续遍历
     * @Function twoSum
     * @author   Oh_MyBug
     * @Date     2020/4/6 15:38
     * @param
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i ++){
            if (map.get(nums[i]) != null){
                if (2*nums[i] == target){
                    return new int[]{(int) map.get(nums[i]), i};
                }
            }
            map.put(nums[i], i);
        }
        for (int num: nums){1. 两数之和
            if (map.get(target - num) != null && (int)map.get(num) != (int)map.get(target - num)){
                return new int[]{(int)map.get(num), (int)map.get(target - num)};
            }
        }
        return null;
    }
}