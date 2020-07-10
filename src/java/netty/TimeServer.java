package netty;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author yinzijian
 */
public class TimeServer {

    public void bind(int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new TimeServerHandler());
                        }
                    });
            ChannelFuture f = b.bind(port).sync();
//            b.bind(port).addListener((ChannelFutureListener) future -> {
//                    // 检查操作的状态
//                    if (future.isSuccess()) {
//                        System.err.println("启动Netty服务成功，端口号：" + port);
//
//                        // 如果操作是成功的，则创建一个ByteBuf 以持有数据
//                        ByteBuf buffer = Unpooled.copiedBuffer("Hello", StandardCharsets.UTF_8);
//                        // 将数据异步地发送到远程节点。返回一个ChannelFuture
//                        ChannelFuture wf = future.channel().write(buffer);
//                        future.channel().closeFuture();
//                        // ...
//                    } else {
//                        // 如果发生错误，则访问描述原因的Throwable
//                        Throwable cause = future.cause();
//                        cause.printStackTrace();
//                    }
//            });
            if(f.isSuccess()){
                System.err.println("启动Netty服务成功，端口号：" + port);
            }
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) throws Exception {
        int port = 8888;

        new TimeServer().bind(port);
    }
}
