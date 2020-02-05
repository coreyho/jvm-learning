package corey.classloadering;

/**
 * @author corey
 * @date 2020-02-04
 */
public class MyTest6 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1:"+Singleton.counter1);
        System.out.println("counter2:"+Singleton.counter2);
    }
}

class Singleton {
    public static int counter1;
    private static Singleton singleton = new Singleton();
    private Singleton() {
        counter1++;
        System.out.println("counter1:"+counter1);
        counter2++;  //准备阶段的重要意义
        System.out.println("counter2:"+counter2);

    }
    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}
