package concurrency;
import	java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
public class AnnounceSeed {

    public void announceSeeds() {
        if (getBlockAwaitingSeedLines() > -1) {
            final CountDownLatch latch = new CountDownLatch(getBlockAwaitingSeedLines());
            new Thread() {

                @Override
                public void run() {
                    while (latch.getCount() > 0) {
                        System.out.println("子线程执行的第"+(11-latch.getCount())+"次");
                        latch.countDown();
                    }
                }
            }.start();
            try {
                latch.await();
                System.out.println("主线程开始了");
            } catch (InterruptedException e) {
                //do nothing
            }
        }
    }
    private int getBlockAwaitingSeedLines() {
        return 10;
    }
    public static void main(String[] args) {
        AnnounceSeed api = new AnnounceSeed();
        api.announceSeeds();
    }
    static List list = new ArrayList();

    public boolean add(Object e) {

        synchronized (list) {
            return list.add(e);
        }
    }

    public synchronized boolean add2(Object e) {
            return list.add(e);
    }
}
