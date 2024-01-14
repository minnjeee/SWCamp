<%@page import="mvc20230619.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 등록 양식</title>
</head>

<script type="text/javascript" src="<%=request.getContextPath()%>/public/js/studentRegister.js" defer ></script>
<!-- 정적리소스를 배포할 때 보통 public 사용 -->
<!-- defer: 모두 로드한 다음에 스크립트를...? -->
<body>
	<h1>학생 등록 양식</h1>
	
	
	
	
	<form name="registerForm" action="./register.do" method="post">
		<p><label> num : 
			<input type="text" name="num" value="" />
		</label></p>
		<p><label> name : 
			<input type="text" name="name" value="" />
		</label></p>
		<p><label> phone : 
			<input type="text" name="phone" value="" />
		</label></p>
		<p><label> address : 
			<input type="text" name="address" value="" />
		</label></p>
		<p><label> birthday : 
			<input type="text" name="birthday" value="" />
		</label></p>
		<p>
			<button type="reset">초기화</button>
			<button type="submit">제출</button>
		</p>
	</form>
</body>
</html>