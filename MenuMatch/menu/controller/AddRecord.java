package menu.controller;

import menu.dto.FoodRecordDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// 기록 db에 메뉴를 추가하는 클래스
public class AddRecord {
    private static Boolean record = false;
    public static void FoodRecordDTO(FoodRecordDTO data) {
        try {
            // 데이터베이스 연결 가져오기
            Connection connection = DBConnecter.getConnection();

            // INSERT 쿼리 실행
            String insertQuery = "INSERT INTO FoodRecord (UserID, MenuName) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, data.getUserID());
            preparedStatement.setString(2, data.getMenuName());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("선택한 메뉴가 기록되었습니다.");
                record = true;
            } else {
                System.out.println("선택한 메뉴가 기록되지 않았습니다.");
            }

            // 연결 종료
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Boolean record_chek (){
        return record;
    }

}
