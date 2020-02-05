package corey.classloadering;

/**
 * @author corey
 * @date 2020-02-05
 *
 * 调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 *
 * Class类的forName方法是对类的主动使用，会初始化类
 */
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("corey.classloadering.CL");
        System.out.println(clazz);
        System.out.println("---------------");
        clazz = Class.forName("corey.classloadering.CL");
        System.out.println(clazz);
    }
}

class CL{
    static {
        System.out.println("Class Cl");

    }
}