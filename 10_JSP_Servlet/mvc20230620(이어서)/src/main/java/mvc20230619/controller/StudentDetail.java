package mvc20230619.controller;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc20230619.dao.DBConnection;
import mvc20230619.dao.StudentDao;
import mvc20230619.dao.StudentDaoImp;
import mvc20230619.dto.StudentDto;

@WebServlet("/student/detail.do")
public class StudentDetail extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//////////////////요청처리 시작/////////////////
		String numStr = req.getParameter("num");
		int num = 0;
		try {
			num = Integer.parseInt(numStr);
		} catch (NumberFormatException e) {
			resp.sendError(400, "num은 꼭 필요한 파라미터 입니다.");
			return;
		}
		//////////////////요청처리 끝/////////////////
		
		StudentDto student = null;
		try {
			Connection conn = DBConnection.getConn();
			StudentDao dao = new StudentDaoImp(conn);
			student = dao.detail(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//////////////////응답처리 시작/////////////////
		// view forward
		if(student!=null) {
			req.setAttribute("student", student);
			req.getRequestDispatcher("/WEB-INF/templates/student/detail.jsp").forward(req, resp);
		}else {
			resp.sendRedirect("./list.do");
		}
		
		
	}
}
