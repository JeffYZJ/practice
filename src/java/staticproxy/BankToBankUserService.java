package staticproxy;
import java.sql.SQLException;
public class BankToBankUserService extends AbstractUserService {
    @Override
    public void delUser(String userId) {

    }

    @Override
    public void addUser(String userId, String userName) throws
            SQLException,
            ClassNotFoundException {
        super.addUser(userId, userName);
        System.out.println("银行间添加的都是超级VIP用户，操作比较犀利");
    }

}
