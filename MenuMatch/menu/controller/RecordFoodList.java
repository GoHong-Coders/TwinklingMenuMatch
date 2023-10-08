package menu.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// 기록 db에서 로그인한 유저가 선택한 메뉴들을 불러오는 클래스
public class RecordFoodList {

    public static List<String> fetchFoodRecords(String userId) {
        List<String> foodRecords = new ArrayList<>();

        try {
            // 데이터베이스 연결 설정
            Connection connection = DBConnecter.getConnection();

            // SQL 쿼리 작성
            String selectQuery = "SELECT * FROM FoodRecord WHERE UserId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, userId);

            // 쿼리 실행 및 결과 처리
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String menuName = resultSet.getString("MenuName");
                foodRecords.add(menuName);
            }

            // 연결 종료
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foodRecords;
    }

    public static void main(String[] args) {
//        테스트 코드
        /* List<String> userFoodRecords = fetchFoodRecords("rei050r");
        for (String menuName : userFoodRecords) {
            System.out.println(menuName);
        } */
    }
}
