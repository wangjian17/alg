package leetcode.meeting;

import java.io.Serializable;

// #.final修饰，避免子类继承，覆盖父类方法，破坏单例
public final class Singleton implements Serializable {
    // #.私有构造方法，避免被外面使用，但无法避免反射构造实例
    private Singleton(){}
    // #.volatile修饰避免指令重排序，读写屏障
    private static volatile Singleton instance;

    public static Singleton getInstance(){
        //#.第一个if判断是否为空，不为空直接返回，避免synchronized同步代码块的执行，多线程场景下频繁加锁会影响性能
        if(instance == null){
            // 首次访问会同步，之后的使用没有synchronized
            synchronized (Singleton.class){
                // #.第二个if判断是否为空，当a线程优先获得锁，执行到此处，b线程没竞争到锁会被阻塞在外面，a线程判断实例是否为空，为空则new实例，a线程释放锁之后，b线程拿到锁进来后判断instance是否为null，此时不为null，则释放锁往下
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    // 如果实现了序列化接口，加这个方法来防止反序列化破坏单例
    public Object readResolve(){
        return instance;
    }
}



