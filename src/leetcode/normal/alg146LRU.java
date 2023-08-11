package leetcode.normal;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class alg146LRU {

}
class LRUCache2 {

    // 默认顺序排列是按照插入顺序
    // 链表头部是最近未使用的
    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRUCache2(int capacity) {

        cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;

    }

    public int get(int key) {
        // 这里还需要更新时间
        if (cache.containsKey(key)) {
            Integer value = cache.remove(key);
            cache.put(key, value);
        }

        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {


        if (cache.containsKey(key)) {
            // 删除
            cache.remove(key);
        }

        // 执行LRU
        if (cache.size() == capacity){
            Integer delKey = cache.keySet().iterator().next();
            cache.remove(delKey);
        }

        cache.put(key, value);
    }
}

class LRUCache {

    // 双向链表， 存放链表节点的位置
    private LinkedList linkedList;


    // 双向链表的节点
    private class ListNode{

        int key;
        int value;

        ListNode pre;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public ListNode() {
        }
    }

    private class LinkedList{
        private ListNode head;
        private ListNode tail;

        private int size = 0;

        public LinkedList() {

            head = new ListNode();
            tail = new ListNode();

            head.next = tail;
            tail.pre = head;

        }

        // 以下所有的形参都用节点表示 不要用key 和 value
        // 尾部添加节点
        public void put(ListNode node){

            // 指向尾部
            node.next = tail;
            // 前一个节点指向你
            tail.pre.next = node;
            // 指向前一个节点
            node.pre = tail.pre;
            // 尾部指向你
            tail.pre = node;

            ++size;
        }

        public void remove(ListNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;

            --size;
        }

        // 复用remove函数
        public ListNode removeHead(){

            if (head.next == tail) {
                return null;
            }

            ListNode node = head.next;
            remove(node);

            return node;
        }

    }

    // Hash表 存放key - value
    HashMap<Integer, ListNode> cache;

    int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        linkedList = new LinkedList();
        cache = new HashMap<>();

    }

    public int get(int key) {

        // 不存在 返回-1
        if (!cache.containsKey(key)){
            return -1;
        }

        // 最近访问
        makeRecently(key);

        // 得到值
        ListNode node = cache.get(key);
        return node.value;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)){
            // 删除
            removeKey(key);
            // 添加
            addRecently(key, value);
            return;
        }

        if (capacity == linkedList.size){
            // 删除
            removeLastRecently();
        }

        addRecently(key, value);
    }


    // 使用以下方法构建上述方法
    private void makeRecently(int key) {
        // 得到节点
        ListNode listNode = cache.get(key);
        // 删除并添加
        linkedList.remove(listNode);
        linkedList.put(listNode);
    }

    private void addRecently(int key, int value) {
        // 创建节点
        ListNode node = new ListNode(key, value);

        // 链表和哈希表都要添加
        cache.put(key, node);
        linkedList.put(node);

    }

    // 删除某个节点
    private void removeKey(int key){

        ListNode node = cache.get(key);

        linkedList.remove(node);
        cache.remove(key);
    }

    private void removeLastRecently(){

        ListNode node = linkedList.removeHead();
        cache.remove(node.key);

    }
}
