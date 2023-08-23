package leetcode.meeting;

public abstract class A {

    public A() {
        print();
    }
    public void print(){
        System.out.println("A");
    }
    public static void main(String[] args) {
        B b = new B();
    }
}

class B extends A{



    B(){
        System.out.println("111");
    }

    @Override
    public void print(){
        System.out.println("B");
    }
}


