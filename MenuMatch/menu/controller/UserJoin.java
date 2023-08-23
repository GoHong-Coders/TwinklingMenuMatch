package menu.controller;
import menu.vo.DBConnecter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import menu.vo.UserVO;

public class UserJoin {

    public static void Join(UserVO data) {
        String user_id = data.getUserId();
        String user_name = data.getUserName();
        String user_pass = data.getUserPass();

        try {
            // 데이터베이스 연결 가져오기
            Connection connection = DBConnecter.getConnection();

            // INSERT 쿼리 실행
            String insertQuery = "INSERT INTO users (user_id, user_name, user_pass) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, user_id);
            preparedStatement.setString(2, user_name);
            preparedStatement.setString(3, user_pass);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("회원가입이 완료되었습니다.");
            } else {
                System.out.println("회원가입에 실패하였습니다.");
            }

            // 연결 종료
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        UserJoin join = new UserJoin();
//        join.Join();
    }
}
