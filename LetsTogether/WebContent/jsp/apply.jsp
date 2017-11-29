<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.dimigo.vo.UserVO" %>
<%@ page import="org.dimigo.vo.ApplyVO" %>
<%@ page import="org.dimigo.service.PostService" %>
<%@ page import="org.dimigo.service.ApplyService" %>
<%@ page import="org.dimigo.dao.ApplyDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Apply</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<style>
	table, thead, tbody, th {
		text-align: center;
		border: 1px solid;
	}
</style>
</head>
<body>
<%@ include file="menu.jsp"%>
<table>
	<thead>
		<tr>
			<th>게시물 번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>취소</th>
			<th>현재 상황</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${ !empty apply }">
			<c:forEach var="item" items="${apply}" varStatus="status">
				<tr>
					<td>${ item.pk }</td>
					<td>${ item.getapplyid }</td>
					<td>${ item.title }</td>
					<td>  
						<form class="form-signin" action="${contextPath}/view2.do" method="post">
							<button name="pk" value="${item.pk}" class="btn btn-lg btn-primary btn-block" type="submit">내용 보기</button>
					  	</form>
					</td>
					<td>
						<form class="form-signin" action="${contextPath}/deleteapply2.do" method="post">
							<button name="pk" value="${item.pk}" class="btn btn-lg btn-primary btn-block" type="submit">취소</button>
				  		</form>	
					</td>
					<td>
						<c:if test="${0 == item.result}">
							<button class="btn btn-lg btn-primary btn-block" type="submit">승인 대기중</button>
				  		</c:if>
						<c:if test="${1 == item.result}">
							<button class="btn btn-lg btn-primary btn-block" style="background: green; border:green" type="submit">승인됨</button>
					  	</c:if>
						<c:if test="${2 == item.result}">
							<button class="btn btn-lg btn-primary btn-block" style="background: red; border:red" type="submit">거절됨</button>
					  	</c:if>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
</body>

<%@ include file="modal.jsp" %>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<c:if test="${error != null}">
<script>
	var myModal = $('#myModal');
	myModal.find('.modal-title').text('Apply Error');
	myModal.find('.modal-body').text('${error}');
	myModal.modal();
</script>
</c:if>
<c:if test="${posting != null}">
<script>
	var myModal = $('#myModal');
	myModal.find('.modal-title').text('${title}');
	myModal.find('.modal-body').text('${posting}');
	myModal.modal();
</script>
</c:if>
</html>