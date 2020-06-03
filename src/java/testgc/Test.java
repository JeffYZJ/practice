package testgc;
import	java.lang.ref.WeakReference;

public class Test extends WeakReference<String> {
    private String strTest = "该Test对象还存在";
    public Test(String referent) {
        super(referent);
    }

    @Override
    public String toString() {
        return strTest;
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("该Test对象被释放了");
    }
}
