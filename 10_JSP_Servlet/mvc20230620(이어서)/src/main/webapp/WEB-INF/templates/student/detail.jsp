<%@page import="mvc20230619.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 상세</h1>
	<% 
		Object studentObj=request.getAttribute("student");
		StudentDto student=(StudentDto)studentObj;
	%>

	<p><strong>num : </strong><span><%=student.getNum()%></span></p>
	<p><strong>name : </strong><span><%=student.getName()%></span></p>
	<p><strong>phone : </strong><span><%=student.getPhone()%></span></p>
	<p><strong>address : </strong><span><%=student.getAddress()%></span></p>
	<p><strong>birthday : </strong><span><%=student.getBirthday()%></span></p>
	<p><a href="./modify.do?num=<%=student.getNum()%>">수정</a></p>
</body>
</html>