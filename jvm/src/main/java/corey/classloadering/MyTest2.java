package corey.classloadering;

/**
 * @author corey
 * @date 2020-02-03
 * 常量在编译阶段会存到调用这个常量的方法所在的类的常量池中，
 * 本质上，调用类并不会直接引用到定义常量的类，因此并不会触发
 * 定义常量的类的初始化
 * 注意：这里指的是将常量存放到MyTest2的常量池中
 *
 * 字节码：
 *    ldc 将int,float或是String类型的常量值从常量池中推送至栈顶（参数是index）
 *    bipush表示将单字节8位（-128~127）的常量值推送至栈顶
 *    sipush表示将一个短整型常量值short（-32768~32767）推送至栈顶
 *    iconst_1 表示将数字1推送至栈顶（-1~5）
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.str);
        System.out.println(MyParent2.s);
        System.out.println(MyParent2.i);

    }
}

class MyParent2{
    public static final String str = "hello world";
    static final short s = 1;
    static final short i = 128;
    static {
        System.out.println("Myparent2 init");
    }
}
