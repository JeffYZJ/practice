package staticproxy;
import java.sql.Connection;
import java.sql.SQLException;
public interface IUserService {
    public static final String URL =
            "jdbc:mysql://127.0.0.1:3306/localams?useUnicode=true&amp;characterEncoding=utf-8";

    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    void addUser(String userId, String userName) throws SQLException, ClassNotFoundException;

    void delUser(String userId);

    Connection completeDBConnet() throws ClassNotFoundException, SQLException;
}
