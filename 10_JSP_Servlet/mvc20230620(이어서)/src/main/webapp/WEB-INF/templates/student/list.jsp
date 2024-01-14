<%@page import="mvc20230619.dto.StudentDto"%>
<%@page import="mvc20230619.dao.StudentDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>mvc student list</h1>
	<p><a href="./register.do">학생 등록</a></p>
	<% 
		//다형성 오버로드, 오버라이드, 타입의다형성
		//객체는 보무의 타입의 변수로 참조될 수 있다.
		//부모의 타입으로 참조하던 변수를 원래 타입으로 변경할 수 있다.(upcasting)
		
		Object studentsObj =request.getAttribute("students");
		List<StudentDto> students = (List<StudentDto>)studentsObj;
	%>
	<table>
		<thead>
			<tr>
				<th>num</th>
				<th>name</th>
				<th>phone</th>
				<th>상세</th>
			</tr>
		</thead>
		<tbody>
			<%for(StudentDto s : students){ %>
				<tr>
					<td><%=s.getNum() %></td>
					<td><%=s.getName() %></td>
					<td><%=s.getPhone() %></td>
					<td> <a href="./detail.do?num=<%=s.getNum()%>">상세</a> </td>
				</tr>
			<% } %>
		</tbody>
	</table>
	
	
</body>
</html>