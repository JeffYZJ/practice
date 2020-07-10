package dubborpc.customer;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.Callable;
public class NettyClientHandler extends ChannelHandlerAdapter implements Callable {
    /**
     * 供外部方法调用
     */
    private ChannelHandlerContext context;
    /**
     * 接收服务器返回结果，供外部方法调用
     */
    private String result;
    /**
     * 设置参数
     */
    private String para;
    /*
    执行顺序
    1)channelActive - setPara
    2)call - wait
    3)channelRead - notify
    4)call - return结果
     */

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
    //    1)
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ChannelActive 调用");
        context = ctx;
    }
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ChannelRead 调用");
        result = msg.toString();
        notify();
    }
    @Override
    public synchronized Object call() throws Exception {
        System.out.println("call1 调用");
        context.writeAndFlush(para);
        wait();//等待channelRead方法获取到服务器结果。
        System.out.println("call2 调用");
        return result;
    }

    public void setPara(String para) {
        this.para = para;
    }
}
