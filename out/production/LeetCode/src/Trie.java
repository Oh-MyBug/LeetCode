/**
 * ClassName:   Tire
 * Data:        2020/8/21
 * author:      Oh_MyBug
 * version:     V1.0
 */

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 向 Trie 树中插入字符串 word
    public void insert(String word) {
        TrieNode node = root;   // 从根开始搜索它对应于第一个键字符的链接
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            // 链接不存在。创建一个新的节点，并将它与父节点的链接相连，该链接与当前的键字符相匹配。
            if (!node.containsKey(currentChar))
                node.put(currentChar, new TrieNode());

            // 链接存在。沿着链接移动到树的下一个子层。算法继续搜索下一个键字符。
            node = node.get(currentChar);
        }
        // 到达键的最后一个字符，然后将当前节点标记为结束节点
        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        // 用第一个键字符从根开始
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            // 检查当前节点中与键字符对应的链接
            char curLetter = word.charAt(i);

            // 存在链接
            if (node.containsKey(curLetter)) {
                // 我们移动到该链接后面路径中的下一个节点，并继续搜索下一个键字符
                node = node.get(curLetter);
            } else {    // 不存在链接
                return null;
            }
        }
        // 无键剩余
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

class TrieNode {

    private TrieNode[] links;    // 链接: 指向下一节点

    private final int R = 26;   // 26 个小写字母

    private boolean end;    // 单词结束标志

    // 无参构造器，初始化 links 数组大小
    public TrieNode() {
        links = new TrieNode[R];
    }

    // 判断当前节点的是否链接了字符 ch
    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }

    // 获取 ch 对应的 Trie 节点
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }

    // 在 ch 节点下存入 node 节点
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }

    // 设置结束标志
    public void setEnd() {
        end = true;
    }

    // 判断单词是否结束
    public boolean isEnd() {
        return end;
    }
}
