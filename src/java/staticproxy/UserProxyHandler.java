package staticproxy;
import java.sql.SQLException;
public class UserProxyHandler {
    private AbstractUserService abstractUserService;
    public UserProxyHandler(AbstractUserService abstractUserService){
        this.abstractUserService = abstractUserService;
    }
    public void addUser(String userId, String userName) throws
            SQLException,
            ClassNotFoundException {
        this.abstractUserService.addUser(userId, userName);
    }


}
