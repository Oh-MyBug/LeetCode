import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:   Solution_133
 * Data:        2020/8/14
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
133. 克隆图
给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
class Node {
    public int val;
    public List<Node> neighbors;
}
测试用例格式：
简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
输出：[[2,4],[1,3],[2,4],[1,3]]
解释：
图中有 4 个节点。
节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
示例 2：
输入：adjList = [[]]
输出：[[]]
解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
示例 3：
输入：adjList = []
输出：[]
解释：这个图是空的，它不含任何节点。
示例 4：
输入：adjList = [[2],[1]]
输出：[[2],[1]]
 */
public class Solution_133 {
    /*
    广度
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        List<Node> queue = new ArrayList<>();
        visited.put(node, new Node(node.val, new ArrayList<>()));
        queue.add(node);

        while (!queue.isEmpty()) {
            Node temp = queue.remove(0);
            for (Node neighbor : temp.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(temp).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
*/
    // 深度
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> lookup = new HashMap<>();
//        return dfs(node, lookup);
        helper(node, null, lookup);
        return lookup.get(node);
    }

    // 差劲
    private void helper(Node cur_node, Node pre_node, Map<Node, Node> visited) {
        if (!visited.containsKey(cur_node))
            visited.put(cur_node, new Node(cur_node.val, new ArrayList<>()));
        if (pre_node != null) {
            if (visited.get(pre_node).neighbors.contains(visited.get(cur_node)))
                return;
            visited.get(pre_node).neighbors.add(visited.get(cur_node));
        }
        for (Node neighbor : cur_node.neighbors)
            helper(neighbor, cur_node, visited);
    }

    // 秒
    private Node dfs(Node node, Map<Node, Node> lookup) {
        if (node == null) return null;
        if (lookup.containsKey(node))
            return lookup.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        for (Node n : node.neighbors)
            clone.neighbors.add(dfs(n, lookup));
        return clone;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
