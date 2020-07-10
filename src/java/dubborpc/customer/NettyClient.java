package dubborpc.customer;
import java.lang.reflect.Proxy;
import	java.util.concurrent.Executors;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.concurrent.ExecutorService;
public class NettyClient {
    private static NettyClientHandler client = null;
    private int count = 0;
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    //编写一个获取代理对象的代理方法
    public Object getBean(final Class<?> serviceClass, final String providerName){
        Object object = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class<?>[]{serviceClass}, ((proxy, method, args) -> {
            if(client == null){
                initClient();
            }
            //设置要发送给服务器端的消息
            client.setPara(providerName + args[0]);
            return executorService.submit(client).get();
        }));
        return object;
    }


    private static  void initClient() throws InterruptedException {
        client = new NettyClientHandler();
        //创建EventLoop
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true).option(ChannelOption.TCP_NODELAY, true);
            bootstrap.group(eventLoopGroup);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) {
                    socketChannel.pipeline().addLast(new StringEncoder());
                    socketChannel.pipeline().addLast(new StringDecoder());
                    socketChannel.pipeline().addLast(client);
                }
            });
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8888).sync();
            if (channelFuture.isSuccess()) {
                System.err.println("连接服务器成功");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
