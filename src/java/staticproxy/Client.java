package staticproxy;
import java.sql.SQLException;
public class Client {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserProxyHandler userProxyHandler = new UserProxyHandler(new BankToBankUserService());
        userProxyHandler.addUser("yzj","yzj2");
    }
}
