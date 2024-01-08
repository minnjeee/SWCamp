package w20230614;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// /student/detail.do
@WebServlet("/student/detail.do")
public class L03JDBCStudentDetail extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//쿼리스트링 -> 파라미터는 모두 문자열!!
		String numStr = req.getParameter("num");
		//클라이언트에게 num 파라미터가 꼭 필요하다고 알려줘야함 -> status 400
//		if(numStr == null) resp.sendError(400);
		int num = 0;
		//?num=1000%20OR%201==1;DROP%20TABLE%20STUDENT
		try {
			num = Integer.parseInt(numStr);
		}catch(NumberFormatException e) {
			resp.sendError(400);
			return;
		}
		String sql = "SELECT * FROM STUDENT WHERE num = ?"; //?없이 + num으로 하면 보안에 좋지 않음
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver"; 
		String user = "c##smart01";
		String pw = "oracle01";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		PrintWriter out = resp.getWriter();
		
		String html = "";
		html += "<h1>학생 상세 정보</h1>";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num); //정수는 sql Injection 불가능 (쿼리는 문자열이라서?)
//			pstmt.setString(2, numStr); //num='1000 or 1=1;' num=1000 or 1=1; (''로 문자열 취급하여 sql Injection방지)
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				html += "<p>num : " + rs.getInt(1) + "</p>"; //"num" 또는 1(첫번째 열,0이 아닌 1부터)
				html += "<p>number : " + rs.getString(2) + "</p>";
				html += "<p>phone : " + rs.getString(3) + "</p>";
				html += "<p>address : " + rs.getString(4) + "</p>";
				html += "<p>birthday : " + rs.getString(5) + "</p>";
				html += "<a href='./modify.do?num=" + rs.getInt("num")+ "'>수정</a>"; //상세와 같은데 수정 양식이 존재
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		html += numStr;
		resp.setContentType("text/html; charset=UTF-8;");
		out.print(html);
	}
}
