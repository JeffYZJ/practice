package jdkproxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class JdkProxySubject implements InvocationHandler {
    private Object realSubject;
    public JdkProxySubject (Subject subject){
        this.realSubject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("befor");
        try {
            //利用反射动态的来反射方法，这就是动态代理和静态代理的区别
            /*
             * Object obj :代理的接口对象
             * Object... args ：接口对象方法的参数
             * */
            method.invoke(realSubject, args);

        } catch (Exception e) {
            System.out.println("ex:"+e.getMessage());
            throw e;
        } finally {
            System.out.println("after+++++++");
        }
        return null;
    }
}
