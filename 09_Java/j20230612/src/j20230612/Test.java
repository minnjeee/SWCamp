package j20230612;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();  // DBConnection 객체 생성
        String query = "SELECT TITLE FROM BOARD_BOARD";  // 실행할 쿼리

        try {
            Connection conn = dbConnection.getConnection();  // DBConnection에서 Connection 객체 얻기
            Statement stmt = conn.createStatement();  // Statement 객체 생성
            ResultSet rs = stmt.executeQuery(query);  // 쿼리 실행하고 결과 받기

            while (rs.next()) {  // 결과 출력
                System.out.println("TITLE: " + rs.getString("TITLE"));
            }

            rs.close();  // ResultSet, Statement, Connection 객체 닫기
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}