package menu.controller;

import menu.dto.LunchDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 점심메뉴 테이블에서 점심 이름과 설명을 가져오는 클래스
public class LunchInfo {

    public static void LunchInfo(LunchDTO data) {
        try {
            int menu_id = data.getMenuID(); // 원하는 메뉴 아이디를 설정

            // 데이터베이스 연결 가져오기
            Connection connection = DBConnecter.getConnection();
            String selectQuery = "SELECT * FROM LunchMenu WHERE MENUID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            preparedStatement.setInt(1, menu_id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // ResultSet에서 필요한 데이터 추출
                String description = resultSet.getString("DESCRIPTION");
                String menu_name = resultSet.getString("MENUNAME");
//                System.out.println(description + " " + menu_name);
                // 추출한 데이터를 변수에 할당
                data.setDescription(description);
                data.setMenuName(menu_name);
            } else {
                System.out.println("메뉴를 찾을 수 없습니다.");
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}
