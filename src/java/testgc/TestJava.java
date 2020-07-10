package testgc;

import java.util.HashMap;
import java.util.Map;

public class TestJava {
    static Map map = new HashMap();
    public static void main(String[] args) throws InterruptedException {

        Test t1 = new Test("1");
        Test t2 = new Test("2");
        map.put(t1, "1");
        map.put(t2, "2");
        map.clear();
        System.gc();

        t1 = null;
        System.out.println("第1步" + t1);


        System.gc();
        System.out.println("第2步" + t2);

        System.gc();
        System.out.println("第3步" + map);

    }
}
