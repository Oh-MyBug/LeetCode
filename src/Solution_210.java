import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:   Solution_210
 * Data:        2020/8/22
 * author:      Oh_MyBug
 * version:     V1.0
 */
/*
210. 课程表 II
现在你总共有 n 门课需要选，记为 0 到 n-1。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
示例 1:
输入: 2, [[1,0]]
输出: [0,1]
解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
示例 2:
输入: 4, [[1,0],[2,0],[3,1],[3,2]]
输出: [0,1,2,3] or [0,2,1,3]
解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 */
public class Solution_210 {
    private List<List<Integer>> edges;
    private boolean valid = true;
    private int[] visited;
    private int[] queue;
    private int cur;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        queue = new int[numCourses];
        visited = new int[numCourses];
        edges = new ArrayList<>();
        cur = numCourses - 1;
        for (int i = 0; i < numCourses; i++)
            edges.add(new ArrayList<>());
        for (int[] prerequisite : prerequisites)
            edges.get(prerequisite[1]).add(prerequisite[0]);
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0)
                helper(i);
        }
        return valid ? queue : new int[0];
    }

    public void helper(int u) {
        visited[u] = 1;
        for (Integer v : edges.get(u)) {
            if (visited[v] == 0) {
                helper(v);
                if (!valid) return;
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
        queue[cur--] = u;
    }
}
