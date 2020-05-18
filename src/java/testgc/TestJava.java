package testgc;

import java.util.HashMap;

public class TestJava {
    public static void main(String[] args) throws InterruptedException {
        HashMap map = new HashMap();
        Test t1 = new Test();
        Test t2 = new Test();
        map.put(t1, "1");
        map.put(t2, "2");
        map.clear();

//        t1 = null;
        System.gc();
        Thread.sleep(5000);
        System.out.println("第1步" + t1.toString());

//        t2 = null;
        System.gc();
        System.out.println("第2步" + map);

        System.gc();
        System.out.println("第3步" + map);

    }
}
