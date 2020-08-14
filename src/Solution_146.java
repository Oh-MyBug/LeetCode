import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:   Solution_146
 * Data:        2020/8/15
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
146. LRU缓存机制
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
示例:

LRUCache cache = new LRUCache(2);// 缓存容量

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
*/
public class Solution_146 {
    private Map<Integer, DLinkedNode> cache;
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public Solution_146(int capacity) {
        head = new DLinkedNode(0, 0);
        tail = new DLinkedNode(0, 0);
        head.next = tail;
        tail.prev = head;

        size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
    }

    public static void main(String[] args) {
//        Solution_146 cache = new Solution_146(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));
//        cache.put(3, 3);    // 该操作会使得关键字 2 作废
//        System.out.println(cache.get(2));
//        cache.put(4, 4);    // 该操作会使得关键字 1 作废
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));
        Solution_146 cache = new Solution_146(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node== null)
            return -1;
        else {
            updateToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {

        DLinkedNode node = cache.get(key);
        // 关键字不存在
        if (node == null) {
            DLinkedNode new_node = new DLinkedNode(key, value);
            addToHead(new_node);
            cache.put(key, new_node);
            if (size < capacity)
                size++;
            else
                cache.remove(removeFromTail().key);
        } else {    // 关键字存在
            node.value = value;
            updateToHead(node);
        }
    }

    private void updateToHead(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }

    private DLinkedNode removeFromTail() {
        DLinkedNode node = tail.prev;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return node;
    }

    private void addToHead(DLinkedNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}
