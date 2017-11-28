<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.dimigo.vo.PostVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta title="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Posting</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<link rel="stylesheet" href="${contextPath}/css/signin.css?ver=1">
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

  <form id="signupForm" class="form-signin" action="${contextPath}/posting.do">
    <h2 class="form-signin-heading">Please Posting</h2>

	<label for="inputTitle" class="sr-only">Title</label>
    <input type="text" name="title" id="inputTitle" class="form-control" placeholder="Title - 글자 수 50자 제한" 
    value="${param.title}">
	
	<label for="inputPost" class="sr-only">Post - 글자 수 150자 제한</label>
    <input type="text" name="post" id="inputPost" class="form-control" placeholder="Post - 글자 수 150자 제한" 
    value="${param.post}">
	
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Posting</button>
  </form>
</div>

<%@ include file="modal.jsp" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<c:if test="${error != null}">
<script>
	var myModal = $('#myModal');
	myModal.find('.modal-title').text('Posting Error');
	myModal.find('.modal-body').text('${error}');
	myModal.modal();
</script>
</c:if>
</body>
</html>