package w20230614;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import oracle.jdbc.driver.OracleDriver;

// " /student/list.do " path의 호출이 오면 톰캣이 L02JDBCStudentList 실행 후 응답 (동적페이지)
// 학생자료 주세요~ (DQL(select) - 모두 get방식)
// 학생자료 등록/수정/삭제 (DML - 대부분 post방식)
//@ 어노테이션 : 컴파일러가 검사(Override, FunctionalInterface), 자동완성(WebServlet)
//	WebServlet : DD(Development Description, web.xml, 웹앱 설정) 배포서술자에 어떤 요청이 왔을 때 어떤 동적 리소스를 호출할 건지 정의하는 것
//	배포서술자 : 톰캣 서버에 개발자가 만든 웹앱을 배포할 때 이렇게 동작할 거야~라는 설정을 정의하는 곳
//@WebServlet("/studetn/list.do") -> 배포서술자(web.xml)에 servlet태그와 servlet-mapping태그가 자동완성 됨
//class System{}

public class L02JDBCStudentList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver"; //import oracledriver를 이용해서 알아내기
		String user = "c##smart01";
		String pw = "oracle01";
		
		String html = "" ;
		html += "<h1>학생 리스트</h1>";
		html += "<table>";
		html += "<tr><th>num</th><th>name</th><th>phone</th><th>address</th><th>birthday</th></tr>";
		//jdbc 통신 후 학생리스트를 가져와서, 학생리스트를 문자열로 변환
		//java.sql.* : jdbc 패키지, 자바로 db 접속을 도와주는 라이브러리(모듈)
		Connection conn = null;
		PreparedStatement pstmt = null; //sql injection 해킹 예방
		ResultSet rs = null;
		//통신, 접속은 오류를 통반하기 때문에 예외처리
		try {
			Class.forName(driver);
			//DriverManager 오라클에 접속할 때 오라클 드라이버를 동적 로딩으로 객체생성한다.
			//	동적 로딩 : 객체가 필요할 때 알아서 만들어 사용한다.
			
			conn = DriverManager.getConnection(url, user, pw);
//			System.out.println(conn);
			String sql = "select * from student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //질의어 실행함수 => 테이블(ResultSet) 반환
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String birthday = rs.getString("birthday");
				
				html += "<tr>";
				html += "<td>"+num+"</td>";
				html += "<td>"+name+"</td>";
				html += "<td>"+phone+"</td>";
				html += "<td>"+address+"</td>";
				html += "<td>"+birthday+"</td>";
				html += "</tr>";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		html += "</table>";
		
		resp.setContentType("text/html; charset=utf-8;");
		resp.getWriter().append(html);
	}
}

























