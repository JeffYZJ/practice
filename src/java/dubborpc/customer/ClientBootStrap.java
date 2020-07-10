package dubborpc.customer;
import dubborpc.HelloService;
public class ClientBootStrap {
    public static final String providerName = "HelloService#hello#";
    public static void main(String[] args) throws InterruptedException {
        NettyClient nettyClient = new NettyClient();

        HelloService service = (HelloService) nettyClient.getBean(HelloService.class, providerName);

        for (;;){
            String msg = service.sayHello("你好 dubbo");
            System.out.println("调用结果：" + msg);
            Thread.sleep(3000);
        }
    }
}
