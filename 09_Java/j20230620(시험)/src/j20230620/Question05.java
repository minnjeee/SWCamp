package j20230620;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


class ConnectionFactory {
	private static final String driverName = "oracle.jdbc.driver.OracleDriver";	//ojdbc.jar
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";	 
	private static final String user = "c##smart01";  //db 사용자 id (connect, resource, dba 권한 할당)
	private static final String password = "oracle01"; // password
	private static Connection conn = null;
	public static Connection getConnection() {
		try {		
			if(conn!=null && !conn.isClosed()) return conn;
			
			Class.forName(driverName); //driver 등록	
			conn = DriverManager.getConnection(url, user, password); //db 연결
		} catch (ClassNotFoundException e) {			
			System.out.println("Connection 인스턴스를 생성하지 못했습니다.");
			System.exit(0);	
		} catch (SQLException e) {}
		return conn; 
	}		 	
}



public class Question05 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			/////1. DB 접속///////
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = null;
			/////2. 테이블 생성 후 데이터 입력///////
			String sql = "create table student1(id number(10) primary key, name varchar2(20), addr varchar2(50))";
			stmt.execute(sql); //create 는 execute로 실행
			System.out.println("테이블 생성이 완료!!");
			
			sql = "INSERT INTO student1 VALUES(100, '이순신', '서울시 서초구')";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO student1 VALUES(200, '김유신', '인천시 남구')";
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO student1 VALUES(300, '강감찬', '수원시 영통구')";
			stmt.executeUpdate(sql);
			System.out.println("3개의 레코드 입력 완료!!");
			
			/////3. 입력된 테이블 내용 화면에 출력///////
			sql = "SELECT * FROM student1 ORDER BY id DESC";
			rs = stmt.executeQuery(sql); // select문은 executeQuery로 실행
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String addr = rs.getString("addr"); 
		
				System.out.println("학번 = " + id);
				System.out.println("이름 = " + name);
				System.out.println("주소 = " + addr);
				System.out.println("=================================================");
			}
			System.out.println("입력된 내용 모두 출력 완료!!");
			
			/////4. 이름이 '신'으로 끝나는 경우 주소를 '서울시 강남구'로 수정 후 수정결과 출력///////	
			sql = "UPDATE student1 SET addr='서울시 강남구' WHERE name LIKE '%신'";
			stmt.executeUpdate(sql);
			System.out.println("수정 완료");
			
			sql = "SELECT * FROM student1 WHERE name LIKE '%신'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String addr = rs.getString("addr"); 
		
				System.out.println("학번 = " + id);
				System.out.println("이름 = " + name);
				System.out.println("주소 = " + addr);
				System.out.println("=================================================");
			}
			System.out.println("수정된 내용 모두 출력 완료!!");
			
			rs.close();
			stmt.close();
			conn.close();
		} catch(SQLException e){
			System.out.println("SQL 오류 = " + e.getMessage());
		}
	}
}
