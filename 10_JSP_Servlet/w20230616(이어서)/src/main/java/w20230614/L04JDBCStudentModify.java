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

@WebServlet("/student/modify.do")
public class L04JDBCStudentModify extends HttpServlet {
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String driver = "oracle.jdbc.driver.OracleDriver"; 
	private final String user = "c##smart01";
	private final String pw = "oracle01"; //다른사람이 수정 못하게 final로 선언
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청처리 : Controller가 하는 일
		String numStr = req.getParameter("num");
		int num = 0;
		try {
			num = Integer.parseInt(numStr);
		} catch (Exception e) { //num이 정수가 아닐 때 에러
			e.printStackTrace();
			resp.sendError(400, "num 파라미터가 없으면 동작하는 페이지가 아닙니다.");
		}
		
		
		String sql = "SELECT * FROM STUDENT WHERE num=?";
		int cnt = 0;
		String name = null, phone=null, address=null, birthday=null;
		try {//try(){}에서 ()안에는 선언만 가능 -> 생성하면 자동으로 finally지정에서 close실행하는 부분(AutoClose) => 사용 어려움 (포기!!)
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				++cnt;
				num = rs.getInt("num");
				name = rs.getString("name");
				phone = rs.getString("phone");
				address = rs.getString("address");
				birthday = rs.getString("birthday");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace(); //db 접속 중 오류 -> status 500(서버오류)
			resp.sendError(500, "db 접속 중 문제가 발생했습니다. 다시 시도하세요!");
			return;
		}
		
		
		String html = "<h1>학생 수정 양식</h1>";
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html; charset=UTF-8;");
		if(cnt==0) {
			html += "<h2>해당 레코드는 존재하지(삭제된 레코드) 않습니다.</h2>";
		}else {
			html += "<form action='./modify.do' method='post'>";
			html += "<p> <label>num : <input name='num' value='"+num+"' readonly /></label> </p>"; //label 안에 input 넣으면 자동 연결
			html += "<p> <label>name : <input name='name' value='"+name+"'/></label> </p>";
			html += "<p> <label>phone : <input name='phone' value='"+phone+"'/></label> </p>";
			html += "<p> <label>address : <input name='address' value='"+address+"'/></label> </p>";
			html += "<p> <label>birthday : <input name='birthday' value='"+birthday+"'/></label> </p>";
			html += "<p><button style='margin-right:20px;'>수정 양식 제출</button>" //button의 default인 type은 'submit'
					+ "<a href='./remove.do?num="+num+"'>삭제</a></p>"; 
			html += "</form>";
		}
		out.print(html);
		
	}
	
	//실제로 수정하는 페이지 (form 에서 요청하는 동적리소스, 액션페이지)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8"); //파라미터의 인코딩이 다른것일 수도 있어서, 글씨 깨지지 않게 하기 위해 사용
		//먼저, 파라미터 받기
		String numStr = req.getParameter("num"); //input의 name속성으로 파라미터 불러오기
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
		
		int modify = 0; //수정 성공 시에
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "UPDATE STUDENT SET name=?, phone=?,address=?,birthday=? WHERE num=?";
			conn = DriverManager.getConnection(url, user, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name); //sql의 ?부분을 순서대로 대입
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setString(4, birthday);
			int num = Integer.parseInt(numStr);
			pstmt.setInt(5, num);
			
			//DQL 결과 -> table(ResultSet)
			//DML 결과 -> 처리되는 행의 수(int)
			modify = pstmt.executeUpdate();
		} catch (Exception e) {
			 e.printStackTrace();
			 resp.sendError(500, "학생 데이터 수정 시 db 오류 발생. 다시 시도하세요!");
			 return; //sendError 사용 시, 무조건 함수 종료해야 함!
		}
		
		resp.setContentType("text/html; charset=UTF-8;");
		if(modify>0) { //처리된 행의 수 > 0 (수정 성공)
//			resp.getWriter().append("<h1>수정 성공</h1>");
			resp.sendRedirect("./detail.do?num="+ numStr);
			// sendRedirect : 서버에서 다른 리소스를 요청(status 302)
		} else { //존재하지 않거나 삭제된 레코드
//			resp.getWriter().append("<h1>수정 실패! 이미 삭제된 레코드 입니다.</h1>");
			resp.sendRedirect("./modify.do?num="+numStr);
		}
		
		//성공 실패 알림! => 성공(상세, 리스트), 실패(수정 폼)
	}
}
