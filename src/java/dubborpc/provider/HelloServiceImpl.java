package dubborpc.provider;
import dubborpc.HelloService;

import java.util.Objects;
/**
 * @author yinzijian
 */
public class HelloServiceImpl implements HelloService {
    static int count = 0;
    @Override
    public String sayHello(String msg) {
        System.out.println("收到客户端消息："+msg);
        if (Objects.isNull(msg)){
            return "收到客户端消息";
        }else {
            return "收到客户端消息["+msg+"]第"+(++count)+"次" ;
        }

    }
}
