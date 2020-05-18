package testgc;

public class Test {
    private String strTest = "该Test对象还存在";

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
