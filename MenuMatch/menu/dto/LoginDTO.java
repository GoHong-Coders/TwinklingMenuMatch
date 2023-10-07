package menu.dto;

public class LoginDTO {
    // 유저 관련 정보
    private String login_id;
    private String login_pass;

    // 생성자
    public LoginDTO(String login_id, String login_pass) {
        this.login_id = login_id;
        this.login_pass = login_pass;
    }

    public LoginDTO() {}

    // Getter 메서드
    public String getLoginId() { return login_id; }

    public String getLoginPass() {
        return login_pass;
    }

    // Setter 메서드
    public void setLoginId(String login_id) {
        this.login_id = login_id;
    }

    public void setLoginPass(String login_pass) { this.login_pass = login_pass; }

    @Override
    public String toString() {
        return "Member [memberId=" + login_id + ", memberPwd=" + login_pass ;
    }
}
