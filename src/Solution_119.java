import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_119
 * Data:        2020/8/5
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
119. 杨辉三角 II
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
示例:
输入: 3
输出: [1,3,3,1]
 */
public class Solution_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        List<Integer> pre_row;
        row.add(1);
        if (rowIndex == 0) return row;
        for (int rowNum = 0; rowNum <= rowIndex; rowNum++) {
            pre_row = row;
            row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < rowNum; j++)
                row.add(pre_row.get(j-1) + pre_row.get(j));
            row.add(1);
        }

        return row;
    }
}
