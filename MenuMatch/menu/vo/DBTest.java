package menu.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // Oracle 데이터베이스 URL
        String user = "system"; // 데이터베이스 사용자 이름
        String password = "1234"; // 데이터베이스 비밀번호

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn=DriverManager.getConnection(
                jdbcUrl,user,password);
        //url,id,password
        if(conn==null) {System.out.println("DB접속에 실패");}
        System.out.println("DB접속 성공");

        conn.close();
    }
}