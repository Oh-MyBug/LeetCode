import java.util.Map;

/**
 * ClassName:   Solution_208
 * Data:        2020/8/20
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
208. 实现 Trie (前缀树)
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
示例:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:
你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
 */

    // 使用一个list
//public class Solution_208 {
//    /**
//     * Initialize your data structure here.
//     */
//    private List<String> list;
//    public Solution_208() {
//        list = new ArrayList<>();
//    }
//
//    /**
//     * Inserts a word into the trie.
//     */
//    public void insert(String word) {
//        list.add(word);
//    }
//
//    /**
//     * Returns if the word is in the trie.
//     */
//    public boolean search(String word) {
//        return list.contains(word);
//    }
//
//    /**
//     * Returns if there is any word in the trie that starts with the given prefix.
//     */
//    public boolean startsWith(String prefix) {
//        for (String s : list) {
//            if (s.startsWith(prefix))
//                return true;
//        }
//        return false;
//    }
//}

public class Solution_208 {
    /**
     * Initialize your data structure here.
     */
    private Map<Character, Map> map;
    private boolean is_string=false;
    private Solution_208 next[]=new Solution_208[26];

    public Solution_208(){}

    public void insert(String word){//插入单词
        Solution_208 root=this;
        char w[]=word.toCharArray();
        for(int i=0;i<w.length;++i){
            if(root.next[w[i]-'a']==null)root.next[w[i]-'a']=new Solution_208();
            root=root.next[w[i]-'a'];
        }
        root.is_string=true;
    }

    public boolean search(String word){//查找单词
        Solution_208 root=this;
        char w[]=word.toCharArray();
        for(int i=0;i<w.length;++i){
            if(root.next[w[i]-'a']==null)return false;
            root=root.next[w[i]-'a'];
        }
        return root.is_string;
    }

    public boolean startsWith(String prefix){//查找前缀
        Solution_208 root=this;
        char p[]=prefix.toCharArray();
        for(int i=0;i<p.length;++i){
            if(root.next[p[i]-'a']==null)return false;
            root=root.next[p[i]-'a'];
        }
        return true;
    }
}
