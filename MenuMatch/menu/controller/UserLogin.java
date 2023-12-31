package menu.controller;

import menu.dto.LoginDTO;
import menu.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 유저 아이디와 비밀번호를 통해 로그인하는 클래스
public class UserLogin {
    private static Boolean login_check = false;
    static UserDTO vo = new UserDTO();

    public static void Login(LoginDTO data) {

        try {
            // 데이터베이스 연결 가져오기
            Connection connection = DBConnecter.getConnection();

            String selectQuery = "SELECT * FROM m_user WHERE u_id = ? AND u_pass = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            // 사용자로부터 입력 받은 로그인 정보
            String login_id = data.getLoginId();
            String login_pass = data.getLoginPass();

            preparedStatement.setString(1, login_id);
            preparedStatement.setString(2, login_pass);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                login_check = true;
                System.out.println("로그인 성공");
                vo.setUserId(login_id);
            } else {
                System.out.println("로그인 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean Login_check() {
        return login_check;
    }

    public static void main(String[] args) {
    }
}
