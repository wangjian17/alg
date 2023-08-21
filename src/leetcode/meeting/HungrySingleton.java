package leetcode.meeting;

public final class HungrySingleton {

    private HungrySingleton(){}

    public static HungrySingleton hungrySingleton = new HungrySingleton();
    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
