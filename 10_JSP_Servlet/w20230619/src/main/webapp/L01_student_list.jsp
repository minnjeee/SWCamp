<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="w20230619.dto.StudentDto"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! //해당 서블릿페이지의 전역 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 리스트</title>
<style>
	table{
		border-collapse: collapse; /* collapse : 테두리 합치기 (기본값:seperate, 테두리 분리) */
	}
	table td,th{
		border: 1px solid;
	}
</style>
</head>
<%
/* 두번째 방법 : dto사용해서 list 바꾸기 (ArraryList사용해야함) */
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String driver = "oracle.jdbc.driver.OracleDriver"; 
String user = "c##smart01";
String pw = "oracle01";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

List<StudentDto> studentList = new ArrayList<StudentDto>();

try{
	String sql = "SELECT * FROM student";
	Class.forName(driver);
	conn = DriverManager.getConnection(url, user, pw);
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	while(rs.next()){
		StudentDto studentDto = new StudentDto();
		studentDto.setNum(rs.getInt("num"));
		studentDto.setName(rs.getString("name"));
		studentDto.setPhone(rs.getString("phone"));
		studentDto.setAddress(rs.getString("address"));
		studentDto.setBirthday(rs.getString("birthday"));
		studentList.add(studentDto);
	}
}catch(Exception e){
	e.printStackTrace();
}
%>
<body>
	<h1>학생 리스트 조회</h1>
	<table style="border:1px solid black;">
		<tr>
			<th>num</th>
			<th>name</th>
			<th>phone</th>
			<th>address</th>
			<th>birthday</th>
			<th>상세</th>
		</tr>
		<%for(StudentDto s : studentList){ %>
			<tr>
				<td><%out.print(s.getNum()); %></td>
				<td><%=s.getName() %></td>
				<td><%=s.getPhone() %></td>
				<td><%=s.getAddress() %></td>
				<td><%=s.getBirthday() %></td>
				<td>
					<a href="./L01_student_detail.jsp?num=<%=s.getNum()%>">상세</a>
				</td>
			</tr>
		<%} %>
	
	</table>
	
	<!-- 첫번째 방법 -->
	<table style="border:1px solid black;">
		<tr>
			<th>num</th>
			<th>name</th>
			<th>phone</th>
			<th>address</th>
			<th>birthday</th>
			<th>상세</th>
		</tr>
	<%
		try{
			String sql = "SELECT * FROM student";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				%>
				<tr>
					<td><%out.print(rs.getInt("num"));%></td>
					<!-- =은 out.print( );와 동일 -->
					<td><%=rs.getString("name")%></td>
					<td><%=rs.getString("phone")%></td>
					<td><%=rs.getString("address")%></td>
					<td><%=rs.getString("birthday")%></td>
					<td>
						<a href="./L01_student_detail.jsp?num=<%=rs.getInt("num")%>">
							상세
						</a>
					</td>
				</tr>
				
				<%
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
	</table>
</body>
</html>