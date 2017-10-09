<!-- 지시자 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 주석 --%>
<%-- 선언부 --%>
<%! private static final String DEFAULT_NAME = "Guest"; %>
<%-- 스크립틀릿 태그 --%>
<% 
	String name = request.getParameter("name");
	if(name == null) name = DEFAULT_NAME;
//	out.println("<h1>Hello, " + name + "<h1>");
%>
</body>
<%-- Expression Tag --%>
<h1>Hello, <%= name %> </h1>
</html>