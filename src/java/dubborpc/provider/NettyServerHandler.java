package dubborpc.provider;
import dubborpc.customer.ClientBootStrap;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
public class NettyServerHandler extends ChannelHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //获取客户端发送的消息，并调用服务
        System.out.println("msg = "+ msg);
        //自定义一个消费端和提供端通信的协议
        if(msg.toString().startsWith(ClientBootStrap.providerName)){
            String result = new HelloServiceImpl().sayHello(msg.toString().substring(msg.toString().lastIndexOf("#")+1));
            ctx.writeAndFlush(result);
        }
    }
}
