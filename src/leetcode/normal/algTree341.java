package leetcode.normal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class algTree341 {
    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    // 实际上NestedInteger本质上是一棵多叉树
    public class NestedIntegerImpl implements NestedInteger{

        private Integer value;
        private List<NestedInteger> nestedIntegerList;


        public NestedIntegerImpl(Integer value) {
            this.value = value;
            this.nestedIntegerList = null;
        }

        public NestedIntegerImpl(List<NestedInteger> nestedIntegerList) {
            this.value = null;
            this.nestedIntegerList = nestedIntegerList;
        }

        @Override
        public boolean isInteger() {

            return value != null;
        }

        @Override
        public Integer getInteger() {
            return value;
        }

        @Override
        public List<NestedInteger> getList() {
            return nestedIntegerList;
        }
    }

    public class NestedIterator implements Iterator<Integer> {

        // 使用LinkedList是为了方便头插
        public LinkedList<NestedInteger> list;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {
            return list.remove(0).getInteger();
        }

        @Override
        public boolean hasNext() {

            // 遍历找到第一个整数
            while (!list.isEmpty() && !list.get(0).isInteger()){

                List<NestedInteger> nestedIntegerList = list.remove(0).getList();
                // 倒序头插
                for (int i = nestedIntegerList.size() - 1; i >= 0; --i) {
                    list.addFirst(nestedIntegerList.get(i));
                }
            }
            return !list.isEmpty();
        }
    }
}
