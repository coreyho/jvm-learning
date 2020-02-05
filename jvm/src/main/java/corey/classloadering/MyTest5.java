package corey.classloadering;

import java.util.Random;

/**
 * @author corey
 * @date 2020-02-04
 *
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化
 * 只有真正使用到了父接口时（如引用接口中所定义的常量时），才会初始化
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}

interface MyParent5{
    public static int a = new Random().nextInt(4);
}

interface MyChild5 extends MyParent5{
    public static int b = 6*a;
}
