package menu.controller;

import menu.dto.AllDeleteRecordDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AllDeleteRecord {
    public boolean deleteFoodRecord(AllDeleteRecordDTO data) {
        try {
            // 데이터베이스 연결 가져오기
            Connection connection = DBConnecter.getConnection();

            // DELETE 쿼리 실행
            String deleteQuery = "DELETE FROM FoodRecord WHERE UserId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, data.getUserId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("선택한 메뉴가 삭제되었습니다.");
                return true;
            } else {
                System.out.println("선택한 메뉴가 삭제되지 않았습니다.");
                return false;
            }
        } catch (SQLException e) {
            // 예외를 적절하게 처리하거나 상위 수준으로 전달
            e.printStackTrace();
            return false;
        }
    }
}
