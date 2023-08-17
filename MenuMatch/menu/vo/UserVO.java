package menu.vo;

public class UserVO {
    // 유저 관련 정보
    private String user_id;
    private String user_name;
    private String user_pass;

    // 생성자
    public UserVO(String user_id, String user_name, String user_pass) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pass = user_pass;
    }

    public UserVO() {

    }

    // Getter 메서드
    public String getUserId() {
        return user_id;
    }

    public String getUserName() {
        return user_name;
    }

    public String getUserPass() {
        return user_pass;
    }

    // Setter 메서드
    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public void setUserPass(String user_pass) {
        this.user_pass = user_pass;
    }
}
