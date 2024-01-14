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

@WebServlet("/student/checkNum.do") //num이 중복되었는지 확인(비동기식 방법 이용->html,json파일 반환)
// {"checkNum":true} : true이면 num이 사용 중, false이면 num이 사용하지 않음
	//"checkNum" 은 key값(반드시 "사용), true는 value값
public class StudentCheckNum extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//////////////////요청처리 시작/////////////////
		String numStr = req.getParameter("num");
		int num = 0;
		try {
			num = Integer.parseInt(numStr);
		} catch (NumberFormatException e) {
			resp.sendError(400);
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
			resp.sendError(500);
			return;
		}
		
		
		//////////////////응답처리 시작/////////////////
		// view forward
		//resp.setContentType("text/html; charset=utf-8");
		resp.setContentType("application/json; charset=utf-8");

		if(student!=null) {resp.getWriter().print("{\"checkNum\":true}");} // json {} object
		else {resp.getWriter().print("{\"checkNum\":false}");}
		
		
	}
}
