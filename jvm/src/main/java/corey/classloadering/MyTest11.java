package corey.classloadering;

/**
 * @author corey
 * @date 2020-02-05
 */
public class MyTest11 {
    public static void main(String[] args) {
        //静态变量属于谁，是对谁的主动使用   子类访问父类的静态变量和静态方法，是对父类的主动使用
        System.out.println(Child3.a);
        System.out.println("------");
        Child3.doSomething();

    }
}

class Parent3{
    static int a = 3;
    static {
        System.out.println("Parent3 init");
    }

    static void doSomething() {
        System.out.println("do something");

    }
}

class Child3 extends Parent3 {
    static {
        System.out.println("Child3 init");
    }
}
