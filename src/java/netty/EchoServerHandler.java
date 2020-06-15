package netty;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
public class EchoServerHandler extends ChannelHandlerAdapter {
    int counter = 0;
    /**
     * 从客户端读数据
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        String body = String.valueOf(msg);
        System.out.println("This is" + ++counter + "times receive client : [" +body+"]");
        body += "$_";
        doWrite(ctx, body);

    }
    /**
     * 写数据到客户端
     * @param ctx
     * @param body
     */
    private void doWrite(ChannelHandlerContext ctx, String body) {
        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
        ctx.writeAndFlush(echo);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }

}
