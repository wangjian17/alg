package leetcode.normal;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class alg460LFU {
}

class LFUCache {

    // 还是一样 尾部为最新 头部为最旧

    // 容量
    int capacity;

    // 存放频率和cache的映射关系
    HashMap<Integer, LinkedHashMap<Integer, Integer>> frequents;

    // 存放key 和 相对应的频率
    HashMap<Integer, Integer> frequentMapping;

    // 存 key 和 value的映射关系
    HashMap<Integer, Integer> values;

    // 最小频率，用于删除
    int minFrequent;
    // 当前元素个数
    int size;


    public LFUCache(int capacity) {

        minFrequent = 1;
        size = 0;
        this.capacity = capacity;
        frequents = new HashMap<>();
        frequentMapping = new HashMap<>();
        values = new HashMap<>();

    }

    public int get(int key) {

        if (!values.containsKey(key)) {
            return -1;
        }

        addFrequent(key);

        return values.get(key);
    }

    public void put(int key, int value) {

        // 修改的逻辑
        if (values.containsKey(key)){
            values.put(key, value);
            addFrequent(key);
            return;
        }

        // 如果超过最大容量，删除最先的元素
        if (capacity == size){
            removeMinFrequentHead();
        }

        // 添加新的节点
        newFrequently(key, value);


    }

    private void newFrequently(int key, int value) {

        minFrequent = 1;

        values.put(key, value);
        frequentMapping.put(key, minFrequent);

        addNode(key, minFrequent);
    }

    private void removeMinFrequentHead() {
        LinkedHashMap<Integer, Integer> cache = frequents.get(minFrequent);
        // 找到头节点
        Integer key = cache.keySet().iterator().next();

        // 删除
        deleteNode(key, minFrequent);

        values.remove(key);
        frequentMapping.remove(key);

    }




    // 增加频率
    private void addFrequent(int key) {

        // 取出当前的频率
        Integer frequent = frequentMapping.get(key);

        // 删除旧的频率
        deleteNode(key, frequent);


        ++frequent;
        // 更新频率
        frequentMapping.put(key, frequent);
        // 插入新的频率

        addNode(key, frequent);

    }

    // 以下两个函数 用于 在frequents里面添加和删除元素
    private void addNode(int key, Integer frequent) {

        if (!frequents.containsKey(frequent)){
            frequents.put(frequent, new LinkedHashMap<>());
        }

        // 2、取出集合
        LinkedHashMap<Integer, Integer> newCache = frequents.get(frequent);
        // 3、添加
        newCache.put(key, values.get(key));

        ++size;
    }


    private void deleteNode(int key, Integer frequent) {
        // 1、得到当前频率的cache
        LinkedHashMap<Integer, Integer> cache = frequents.get(frequent);

        // 2、删除当前元素
        cache.remove(key);

        // 3、如果cache不存在元素 删除整个cache
        if (cache.size() == 0) {
            frequents.remove(frequent);

            if (frequent == minFrequent){
                ++minFrequent;
            }
        }

        --size;
    }

}