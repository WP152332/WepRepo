<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.dimigo.vo.UserVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Company</title>
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

<div class="container">
<h1>안녕하세요, 우리 함께 해요 입니다.</h1>
<p>
우리 함께 해요는 말그대로 함께 하는 사람을 모집합니다.<br>
집을 가고 싶을 때도, <br>
밥을 먹고 싶을 때도, <br>
프로젝트를 진행 하고자 할때도, <br>
인간이라는 존재는 혼자하기가 힘들고, <br>
함께 할 사람을 구하고는 합니다. <br>
그런 사람들에게 함께 할 사람을 구해주고자 하는 마음에 <br>
창설된 우리 함께 해요는 작성, 신청, 승인 3단계로 <br>
여러분의 연결다리가 되어드립니다.
</p>
</div>

<!-- Bootstrap js -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>