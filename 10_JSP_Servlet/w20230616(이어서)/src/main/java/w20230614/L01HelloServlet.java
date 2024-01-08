package w20230614;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//패키지?
//모듈 : 배포되거나 실행될 수 있는 가장 작은 단위
//패키지 : 모듈의 집합 (기능별로 집합생성), class의 이름을 유일하게 만든다.
//java.lang.* : 자바 언어의 기본 문법에 필요한 것들 Integer,Short,...(Wrapper클래스), System
//java.util.* : 언어에서 조금 더 고급진, 간혹 import해서 사용하는 모듈의 집합
//데이터
//	기본형(원시형) : int,short,byte,long,float,double,char,boolean -> 수(컴퓨터가 기본적으로 연산or저장하는 대상)
//	자료형(참조형) : class, 여러 데이터가 참조되는 자료들(다수의 기본형이 모여 자료형이 된다.)
class System2{}
//HttpServlet : 동적 리소스, 서블릿 (요청이 오면 처리해서 응답) (연산, db접속 jdbc, api호출 ...)
//요청의 방식 : post(양식 제출), get(리소스 찾거나 공유)

//@WebServlet("/hello.do") //do동적리소스
public class L01HelloServlet extends HttpServlet {
	int a = 0; //기본형(수는 없으면 0)
	String s = null; //참조형(자료는 없으면 null)
	
	//doG -> ctrl+space 자동완성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//HttpServletRequest req : 요청정보 (url, 클라이언트의 브라우저정보, os, ...)
		//HttpServletResponse resp : 요청을 처리해서 응답할 내역(문자열 => html, json, css,js,text...)
		
		// get 방식으로 오는 요청을 처리 가능
		// url?a=10&b=20 : 동적리소스가 어떻게 처리되었으면 하는지 알려주는 것(요청)
		// url : 서버에 리소스를 요청하는 일
		// www.naver.com/ : 서버 ip (서버주소)
		// 	/book.do?id=124691 : 해당 서버에 있는 리소스의 주소 (파라미터 있는 것은 모두 동적 리소스)
		//	?id=124691&author=마크주크버 : 쿼리스트링(동적리소스에 포함될 내용을 알려주는 것)
		String aStr = req.getParameter("a"); //쿼리스트링에 포함된 a를 찾아서 반환
		String bStr = req.getParameter("b");
		int a=0, b=0;
		//**톰캣서버가 해당 동적페이지에 오류가 있으면 알리기 위해 500상태(status)를 표시 (서버오류)
		try {
			a = Integer.parseInt(aStr);
			b = Integer.parseInt(bStr);
		}catch(NumberFormatException e) {
			//log로 저장하거나 테스트
			e.printStackTrace();
		}
		
		
		resp.setContentType("text/html;charset=UTF-8"); //문서의 메타(상세)정보는 헤더에 포함
		String htmlStr = "<h1>안녕 동적리소스 서블릿!</h1>";
		htmlStr += "<h2>axb="+(a*b)+"</h2>";
		PrintWriter out = resp.getWriter();
		out.append(htmlStr);
		//resq.getWriter() 에 문자열을 담아 놓으면 자동으로(함수 실행이 끝나면) 응답
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 해당 리소스를 post방식으로 요청하면 톰캣서버(main)가 해당 리소스의 doPost를 실행
		//톰캣이 요청 정보(url)를 HttpServletRequest req 를 참조해서 doPost를 실행
		//**URL은 무조건 데이터를 문자열로 전달
		String aStr = req.getParameter("a");
		String bStr = req.getParameter("b");
		
		//resp.getWriter() 에 문자열을 담아 놓으면 doPost 실행이 끝나고 응답 리소스로 해당 문자열을 사용한다.
		//만약 문자열의 형식을 지정하면 해당 문자열을 그 형식의 문서로 전달(default : text/html)
		resp.setContentType("text/html; charset=UTF-8;"); //text형식의 html이다!
		resp.getWriter()
			.append("<h1>hello.do doPost()</h1>")
			.append("<h2>post 방식은 양식을 제출할 때 사용합니다.</h2>")
			.append("<p> a + b = " + (aStr + bStr) + "</p>");
	}

}
