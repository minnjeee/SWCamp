<%@page import="mvc20230619.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 수정 양식</title>
</head>
<body>
	<h1>학생 수정 양식</h1>
	<% 
		Object studentObj = request.getAttribute("student");
		StudentDto student = (StudentDto)studentObj;
	%>
	<form name="modifyForm" action="./modify.do" method="post">
		<p><label> num : <%=student.getNum() %>
			<input type="hidden" name="num" value="<%=student.getNum() %>" />
			<!-- 수정불가능하게 하기 : input의 type을 hidden으로 설정 or input을 readonly로 설정 -->
		</label></p>
		<p><label> name : 
			<input type="text" name="name" value="<%=student.getName() %>" />
		</label></p>
		<p><label> phone : 
			<input type="text" name="phone" value="<%=student.getPhone() %>" />
		</label></p>
		<p><label> address : 
			<input type="text" name="address" value="<%=student.getAddress() %>" />
		</label></p>
		<p><label> birthday : 
			<input type="text" name="birthday" value="<%=student.getBirthday() %>" />
		</label></p>
		<p>
		<!-- 브라우저의 주소창(window.location)의 주소(href)를 바꾸는 것은 a태그와 같은 행동 -->
			<button type="reset">초기화</button>
			<button type="submit">제출</button>
			<button onclick="location.href='./remove.do?num=<%=student.getNum() %>';" type="button">콜백함수 이용한 삭제</button>
			<!-- onclick="콜백함수" -->
			<button name="removeBtn" type="button">자바스크립트를 이용한 삭제</button>
		</p>
		<p>form submit 이벤트 : 양식 데이터를 action 페이지에 제출(type이 submit인 버튼이 발생시킨다.)</p>
	</form>
	<!-- script는 form태그 밑에 써야함 -->
	<script type="text/javascript">
		//밑에 3가지를 사용하면 form태그 위에서 사용 가능하다(면접에서 나오는 질문)
		//window.onload = function(e){} //브라우저가 문서(document)를 모두 로딩(컴포넌트로 만들어서 출력)
		//document.addEventListener("DOMContentLoaded", (e)=>{});
		//script를 리소스로 지정할 때 defer속성을 줌.(html이 모두 로딩되면 해당 스크립트를 다운로드)
		console.log(modifyForm.removeBtn); //form태그의 name속성을 아이디처럼 사용가능
		modifyForm.removeBtn.onclick = function(e){
			location.href = "./remove.do?num="+modifyForm.num.value;
		}
	</script>
</body>
</html>