package w20230614;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/hw/studentList.do")
public class AssignmentCRUD extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "c##smart01";
		String pw = "oracle01";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String html = "" ;
		String button = req.getParameter("button");

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			
			if (button.equals("insert")) {
				int num = Integer.parseInt(req.getParameter("num"));
				String name = req.getParameter("name");
				String phone = req.getParameter("phone");
				String address = req.getParameter("address");
				String birthday = req.getParameter("birthday");
				
				String sql = "insert into student values(" + num + ",'" + name + "','"
						+ phone + "', '" + address + "', '" + birthday + "')" ;
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate(); //DML 실행
				html += "<h>학생 등록 완료</h1>";
			}
			else if(button.equals("update")) {
				String name = req.getParameter("name");
				
				int num = Integer.parseInt(req.getParameter("num"));
				String phone = req.getParameter("phone");
				String address = req.getParameter("address");
				String birthday = req.getParameter("birthday");
				
				String sql = "update student set num=" + num + ", phone='" + phone 
						+ "', address='" + address + "', '" + birthday + "') where name = '"+name+"'" ;
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate(); //DML 실행
				html += "<h>학생 수정 완료</h1>";

			}
			else if(button.equals("delete")) {
				String name = req.getParameter("name");
				String sql = "delete from student where name='"+name+"'";
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
				html += "<h>학생 삭제 완료</h1>";

			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		resp.setContentType("text/html; charset=utf-8;");
		resp.getWriter().append(html);
	}
}
