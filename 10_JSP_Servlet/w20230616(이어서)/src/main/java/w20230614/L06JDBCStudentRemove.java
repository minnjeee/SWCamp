package w20230614;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student/remove.do")
public class L06JDBCStudentRemove extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String numStr = req.getParameter("num");
		int num = 0;
		try {
			num = Integer.parseInt(numStr);
		} catch (NumberFormatException e) {
			resp.sendError(400, "num을 꼭 보내야 삭제할 수 있습니다.");
			return;
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver"; 
		String user = "c##smart01";
		String pw = "oracle01";
		Connection conn = null;
		PreparedStatement pstmt = null; 
		int remove = 0; //삭제되면 1, 실패하면 0
		try {
			String sql = "DELETE FROM student WHERE num = ?";
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			remove = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500, "예기치 못한 서버(db)오류 발생");
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(remove>0) resp.sendRedirect("./list.do");
		else resp.sendRedirect("./modify.do?num="+numStr);
	}
}
