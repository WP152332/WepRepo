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
<title>MyPage</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link rel="stylesheet" href="${contextPath}/css/signin.css?ver=1">
<style>
p {
  text-align: center;
}
div.container {
  padding-top: 30px;
  padding-bottom: 20px;
}
</style>
</head>
<body>

<%@ include file="menu.jsp"%>

<div class="container">
  <form class="form-signin" action="${contextPath}/mypage.do" method="post">
    <label for="Name" class="sr-only">name</label>
	<p> 바꾸고자 하는 것들만 채워 넣으세요. <br> Intro와 Etc는 null이라고 넣으면 <br> 공백이 됩니다. </p>
    <input type="text" name="name" id="name" class="form-control" placeholder="name"
    value="${param.name}" autofocus>
    
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="Password">
	
	<label for="inputIntro" class="sr-only">Introduction</label>
    <input type="text" name="intro" id="inputIntro" class="form-control" placeholder="Intro">
	
	<label for="inputEtc" class="sr-only">Etc</label>
    <input type="text" name="etc" id="inputEtc" class="form-control" placeholder="Etc">
	
	<label for="inputNowPassword" class="sr-only">NowPassword</label>
    <input type="password" name="nowpwd" id="inputnowPassword" class="form-control" placeholder="보안상 이유로 현재 Password를 입력해주세요" required>
	
    <button class="btn btn-lg btn-primary btn-block" type="submit">Change</button>
  </form>
</div>

<%@ include file="modal.jsp" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<c:if test="${error != null}">
<script>
	var myModal = $('#myModal');
	myModal.find('.modal-title').text('Change Error');
	myModal.find('.modal-body').text('${error}');
	myModal.modal();
</script>
</c:if>
</body>
</html>