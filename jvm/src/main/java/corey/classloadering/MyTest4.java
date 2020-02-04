package corey.classloadering;

/**
 * @author corey
 * @date 2020-02-03
 * 对于数组实例来说，其类型是由JVM在运行期动态生成的，表示为[Lcorey.classloadering.MyParent4
 * 这种类型，动态生成的类型，其父类是Object
 *
 * 字节码
 * anewarray：表示创建一个引用类型的数组，并将其引用至压入栈顶
 * newarray：表示创建一个指定的原始类型（如 int、float、char等）的数组，并将其引用至压入栈顶
 */
public class MyTest4 {
    public static void main(String[] args) {
        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass());

    }
}

class MyParent4{
    static {
        System.out.println("MyParent4 init");
    }
}
