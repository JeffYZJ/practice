package jdkproxy;
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("请求来了");
    }
    @Override
    public void hello() {
        System.out.println("请求say hello");
    }
}
