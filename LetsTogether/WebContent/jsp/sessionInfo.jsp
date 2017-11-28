<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.dimigo.vo.UserVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<style>
div.container {
  padding-top: 30px;
  padding-bottom: 20px;
}
</style>
</head>
<body>

<%@ include file="menu.jsp"%>
<%
	UserVO U = (UserVO)session.getAttribute("U");
%>
<div class="container">
<h1>id: <%= U.getId() %></h1>
<h1>name: <%= U.getName() %></h1>
<h1>intro: <%if(U.getIntro() == null) {%> <%= " " %> <% } else { %> <%= U.getIntro() %> <% } %></h1>
<h1>etc: <%if(U.getEtc() == null) {%> <%= " " %> <% } else { %> <%= U.getEtc() %> <% } %></h1>
</div>

<!-- Bootstrap js -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>