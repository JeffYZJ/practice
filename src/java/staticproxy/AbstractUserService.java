package staticproxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public abstract class AbstractUserService implements IUserService {
    @Override
    public void addUser(String userId, String userName) throws
            SQLException,
            ClassNotFoundException {
        //TODO 模拟插入数据库操作
        Connection conn = completeDBConnet();


    }

    @Override
    public Connection completeDBConnet() throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        final Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
    }

}
