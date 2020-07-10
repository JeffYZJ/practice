package jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/**
 * 场景类
 */
public class Client {
    public static void main(String[] args) {
        InvocationHandler handler =  new JdkProxySubject(new RealSubject());

       Subject subject1 =
               (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[] {Subject.class}, handler);
        subject1.request();
        subject1.hello();


    }
}
