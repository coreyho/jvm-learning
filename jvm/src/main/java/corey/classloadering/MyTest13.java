package corey.classloadering;

/**
 * @author corey
 * @date 2020-02-05
 */
public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        while (systemClassLoader != null) {
            systemClassLoader = systemClassLoader.getParent();
            System.out.println(systemClassLoader);
        }

    }
}
