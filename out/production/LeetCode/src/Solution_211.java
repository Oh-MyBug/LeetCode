/**
 * ClassName:   Solution_211
 * Data:        2020/8/23
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
211. 添加与搜索单词 - 数据结构设计
如果数据结构中有任何与word匹配的字符串，则bool search（word）返回true，否则返回false。 单词可能包含点“。” 点可以与任何字母匹配的地方。
请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
实现词典类 WordDictionary ：
WordDictionary() 初始化词典对象
void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
示例：
输入：
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
输出：
[null,null,null,null,false,true,true,true]
解释：
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 */
public class Solution_211 {

    private TrieNode root;

    public Solution_211() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        Solution_211 solution_211 = new Solution_211();
        solution_211.addWord("bad");
        solution_211.addWord("dad");
        solution_211.addWord("mad");
        solution_211.addWord("pad");
        System.out.println(solution_211.search("bad"));
        System.out.println(solution_211.search(".ad"));
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containKey(c))
                node.put(c, new TrieNode());
            node = node.get(c);
        }
        node.end = true;
    }

    public boolean search(String word) {
        boolean[] res = new boolean[1];
        helper(word, word.length(), 0, root, res);
        return res[0];
    }

    public void helper(String word, int len, int index, TrieNode node, boolean[] res) {
        if (node == null) return;
        if (index == len) {
            if (!node.isEnd()) return;
            res[0] = true;
            return;
        }
        char c = word.charAt(index);
        if (c != '.') {
            helper(word, len, index + 1, node.get(c), res);
        } else {
            for (int i = 0; i < TrieNode.R; i++) {
                TrieNode trieNode = node.get((char) (i + 'a'));
                if (trieNode != null) {
                    helper(word, len, index + 1, trieNode, res);
                    if (res[0]) return;
                }
            }
        }
    }

    static class TrieNode {
        public static final int R = 26;
        private TrieNode[] links;
        private boolean end;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containKey(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void put(char c, TrieNode trieNode) {
            links[c - 'a'] = trieNode;
        }

        public boolean isEnd() {
            return end;
        }
    }
}
