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

@WebServlet("/student/modify.do")
public class StudentModify extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = 0;
		try {
			num = Integer.parseInt(req.getParameter("num"));
		} catch (NumberFormatException e) {
			resp.sendError(400,"num이 없거나 형식이 잘못됨");
		}
		
		StudentDto student = null;
		try {
			Connection conn = DBConnection.getConn();
			StudentDao studentDao = new StudentDaoImp(conn);
			student = studentDao.detail(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(student != null) {
			req.setAttribute("student", student);
			req.getRequestDispatcher("/WEB-INF/templates/student/modify.jsp").forward(req, resp);
		}else {//이미 삭제된 레코드
			resp.sendRedirect("./list.do");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//action page는 양식 데이터를 처리하는 일
		int update = 0; //수정 성공하면 1(>0) : detail.do, 실패하면 0 :modify.do
		
		StudentDto student = new StudentDto();
		student.setNum(Integer.parseInt(req.getParameter("num")));
		student.setName(req.getParameter("name"));
		student.setPhone(req.getParameter("phone"));
		student.setAddress(req.getParameter("address"));
		student.setBirthday(req.getParameter("birthday"));
		System.out.println(student.toString()); //한글깨지면 위의 req.setCharacterEncoding 지정
		Connection conn = null;
		
		try {
			conn = DBConnection.getConn();
			StudentDao studentDao = new StudentDaoImp(conn);
//			conn.commit();
			update = studentDao.update(student);
		} catch (Exception e) {
			e.printStackTrace();
//			try {
//				conn.rollback();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
		}
		
		if(update>0) resp.sendRedirect("./detail.do?num="+student.getNum());
		else resp.sendRedirect("./modify.do?num="+student.getNum());
		
	}
}
