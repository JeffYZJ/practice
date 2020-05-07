package dto;

public class UserDTO {
    public UserDTO(String userCode, String userPwd, Long userId){
        this.userCode = userCode;
        this.userPwd = userPwd;
        this.userId = userId;
    }

    protected String userCode;
    protected String userPwd;
    protected Long userId;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userCode='" + userCode + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userId=" + userId +
                '}';
    }
}
