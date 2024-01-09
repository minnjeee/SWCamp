<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="w20230619.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 상세</title>
</head>
<body>
	<%
		String numStr = request.getParameter("num");
		int num = 0;
		try{
			num = Integer.parseInt(numStr);
		}catch(NumberFormatException e){
			e.printStackTrace();
			response.sendError(400, "num를 꼭 보내야 합니다.");
			return;
		}
		
		StudentDto studentDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver"; 
		String user = "c##smart01";
		String pw = "oracle01";
		try{
			String sql = "SELECT * FROM student WHERE num=?";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				studentDto = new StudentDto();
				studentDto.setNum(rs.getInt("num"));
				studentDto.setName(rs.getString("name"));
				studentDto.setPhone(rs.getString("phone"));
				studentDto.setAddress(rs.getString("address"));
				studentDto.setBirthday(rs.getString("birthday"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(studentDto == null){ //조회된 내역이 없다면 (->1. 레코드가 존재하지 않다는 메시지 출력 2. 리스트로 보내기)
			response.sendRedirect("./L01_student_list.jsp");
			return;
		}
	%>
	
	<h1>학생 상세 조회</h1>
	<p><strong>번호 : </strong><span><%=studentDto.getNum() %></span></p>
	<p><strong>이름 : </strong><span><%=studentDto.getName() %></span></p>
	<p><strong>폰 : </strong><span><%=studentDto.getPhone() %></span></p>
	<p><strong>주소 : </strong><span><%=studentDto.getAddress() %></span></p>
	<p><strong>생일 : </strong><span><%=studentDto.getBirthday() %></span></p>
	
</body>
</html>