package corey.classloadering;

/**
 * @author corey
 * @date 2020-02-03
 * 对于静态字段，只有直接定义了这个字段的类才会被初始化，
 *     因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化
 * 当一个类在初始化时，要求其父类必须全部都已经初始化完毕
 * -XX:+TraceClassLoading
 *   -XX:+<option>,表示开启option选项
 *   -XX:-<option>,表示关闭option选项
 *   -XX:<option>=<value>,将option选项的值设置为value
 */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
        // System.out.println(MyChild1.str1);
    }
}

class MyParent1{
    static String str = "hello world";
    static {
        System.out.println("SuperClass init!");
    }
}

class MyChild1 extends MyParent1 {
    static String str1 = "hello world";
    static {
        System.out.println("SubClass init");
    }
}