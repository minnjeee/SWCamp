<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!-- <html>
<head>
	<title>Home</title>
</head>
<body> -->
<div>
	<a href="<%= request.getContextPath() %>/test?num=100&name=홍길동">접속하기1</a> <!-- /home/ 생략해도 자동으로 앞에 붙음 -->
	<a href="<%= request.getContextPath() %>/test2?no=200&id=ggm">접속하기2</a>
	<a href="<%= request.getContextPath() %>/test3?num=300&username=이순신&tel=010-1234-5678">접속하기3</a>
	<a href="<%= request.getContextPath() %>/test5/4">접속하기4</a> <!-- "test5?page=4" 와 동일 -->
	<%= request.getContextPath() %> <!-- "/home"과 동일 -->
	<a href="<%= request.getContextPath() %>/test5/5">접속하기4</a> <!-- /5때문에 하위가 생김 => 모든 주소에 getContextPath()앞에 붙여야 어딜 클릭해도 에러x -->
</div>
<div>
	<h2>받은 데이터</h2>
	<ol>
		<li>이름 : ${name }</li>
		<li>연락처 : ${tel }</li>
		<li>${num }, ${id }</li>
		<li>DTO : ${dto.num }, ${dto.username }, ${dto.tel }</li>
	</ol>
</div>
<div>
	<h2>post방식의 전송</h2>
	<form action="<%= request.getContextPath() %>/test4" method="post">
		이름 : <input type="text" name="username" />
		주소 : <input type="text" name="addr" />
		<input type="submit" value="서버로 보내기" />
	</form>
</div>
<img alt="" src="<%= request.getContextPath() %>/img/cat.jpg" />   <!-- webapp을 기준으로 주소 지정 -->
<!-- </body>
</html> -->
