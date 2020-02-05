package corey.classloadering;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author corey
 * @date 2020-02-05
 */
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        String resourceName = "corey/classloadering/MyTest13.class";
        Enumeration<URL> urls = contextClassLoader.getResources(resourceName);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }
    }
}
