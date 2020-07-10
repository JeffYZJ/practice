import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

import	java.util.concurrent.atomic.AtomicBoolean;
public class TestAny {
    public static void main(String[] args) {
//        int a = 50;
//        int b = 2;
//        System.getProperty("line.separator");
//        for (int c = 0; c < a; c++) {
//            System.out.print(c + System.getProperty("line.separator"));
//        }
//        System.out.print(0);
        boolean b = true;
        int a = 1;
        System.out.println(a = b ? 1 : 0);;

        AtomicBoolean atomicBo = new AtomicBoolean(false);
        atomicBo.set(false);
        System.out.println(atomicBo.getAndSet(true));
        System.out.println(atomicBo.getAndSet(false));
        test1();
    }
    private static void test1() {
//        ExecutorService executors = Executors.newScheduledThreadPool(1);
//        //最多同时 n 个线程在执行状态
//        //要想运行，注掉下面4行
//        int n = 3;
//        executors = Executors.newFixedThreadPool(n);
//        executors = Executors.newSingleThreadExecutor();
//        executors = Executors.newScheduledThreadPool(n);
//        for (int i = 0; i < 5; i++) {
//            if (executors instanceof ScheduledExecutorService) {
//                //延迟1秒后每3秒执行一次
//                ((ScheduledExecutorService) executors).scheduleAtFixedRate(//延迟1秒后每3秒执行一次
//                        new MyRunnable(i), //延迟1秒后每3秒执行一次
//                        1, //延迟1秒后每3秒执行一次
//            }
//        }
//        executors.shutdown();
        // executors.shutdownNow();
    }
}
