package w20230614;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/register.do")
public class L05JDBCStudentRegister extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 받기
		String numStr = req.getParameter("num");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String birthday = req.getParameter("birthday");
		
		// 잘 출력되는 지 확인 코드
//		System.out.println(numStr);
//		System.out.println(name);
//		System.out.println(phone);
//		System.out.println(address);
//		System.out.println(birthday);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver"; 
		String user = "c##smart01";
		String pw = "oracle01";
		int register = 0; //성공하면 1, 실패하면 0 을 담은 변수
		Connection conn = null;
		PreparedStatement pstmt = null; //undefined 형태 : 절대 사용할 수 없는 형태
							//전역변수는 선언만 하면 undefined형태 (지역변수에서는 선안민 불가능)
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO student(num, name, phone, address, birthday) VALUES (?,?,?,?,?)";
			Class.forName(driver); //동적로딩할 클래스를 미리 찾아두는 것
			conn = DriverManager.getConnection(url, user, pw); //jdbc:oracle: => 오라클 드라이버를 찾아서 생성(동적로딩)
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(numStr));
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
			pstmt.setString(4, address);
			pstmt.setString(5, birthday);
			register = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			//num이 수가 아니거나 없을 때
			//num이 중복 되었을 때
			//접속을 못하거나 db에 문제가 있을 때
//			resp.sendError(500, "num는 꼭 입력되어야 하고 중복될 수 없습니다. or db나 서버에 오류가 발생했습니다.");
//			return; //오류발생 시 서버 종료
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		if(register>0) {
			resp.sendRedirect("./list.do");
		}else { //등록은 실패 오류가 발생하지 0을 잘 반환하지 않음
			resp.sendRedirect("./L05StudentRegister.html");
		}
	}
	
	
}

//URL에서 ENTER -> GET방식이다!!
