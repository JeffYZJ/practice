package dubborpc.provider;
public class ServerBootStrap {
    public static void main(String[] args) throws InterruptedException {
        new NettyServer("localhost", 8888);
    }
}
