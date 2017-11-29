<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<link rel="stylesheet" href="${contextPath}/css/menu.css?ver=3">
<nav id="MB" class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a id="Brand" class="navbar-brand" href="${contextPath}/jsp/home.jsp">우리 함께 해요</a>
	<div class="collapse navbar-collapse" id="navbarSupportedContent"> 
		<ul class="navbar-nav mr-auto">
			 <li class="nav-item dropdown">
		     	<a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    		게시물
		      	</a>
		      	<div class="dropdown-menu dropdown-menu-right" aria-labelledby="bd-versions">
		      		<a href="${contextPath}/post.do"><button type="button" class="dropdown-item">게시물 보기</button></a>
		        	<c:if test="${!empty U}"><button type="button" class="dropdown-item" onclick="location='${contextPath}/jsp/posting.jsp'">게시물 작성</button></c:if>
		      	</div>
		    </li>
		  	<li class="nav-item dropdown">
		     	<a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    		더 보기
		      	</a>
		      	<div class="dropdown-menu dropdown-menu-right" aria-labelledby="bd-versions">
		      		<a href="${contextPath}/jsp/notice.jsp"><button type="button" class="dropdown-item">공지사항</button></a>
		        	<button type="button" class="dropdown-item" onclick="location='${contextPath}/jsp/company.jsp'">기업 소개</button>
		      	</div>
		    </li>
		    <%-- 세션에 사용자 정보가 없는 경우 --%>
		  	<c:if test="${ U == null }">
		  		<li class="nav-item">
		  			<a class="nav-link" href="${contextPath}/jsp/login.jsp">Sign in</a>
		  		</li>
		    	<li class="nav-item">
		  			<a class="nav-link" href="${contextPath}/jsp/signup.jsp">Sign up</a>
		  		</li>
	  		</c:if>
		    <c:if test="${!empty U}">
		    <%-- 세션에 사용자 정보가 있는 경우 --%>
			    <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
				    <li class="nav-item dropdown">
				      <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    	마이페이지
				      </a>
				      <div class="dropdown-menu dropdown-menu-right" aria-labelledby="bd-versions">
			        	<button type="button" class="dropdown-item" onclick="location='${contextPath}/jsp/sessionInfo.jsp'"><c:out value="${ U.name }"></c:out>님의 마이페이지</button>
				      	<div class="dropdown-divider"></div>
				        <button type="button" class="dropdown-item" onclick="location='${contextPath}/jsp/mypage.jsp'">회원 정보 수정</button>
							<a href="${contextPath}/applylist.do"><button type="button" class="dropdown-item">신청 관리</button></a>
							<a href="${contextPath}/admissionlist.do"><button type="button" class="dropdown-item">승인 관리</button></a>
				        <button type="button" class="dropdown-item" onclick="location='${contextPath}/jsp/signout.jsp'">회원 탈퇴</button>
				      </div>	
				    </li>
				    <li class="nav-item">
		  	    		<a class="nav-link" href="${contextPath}/logout.do">Sign out</a>
				    </li>
			    </ul>
		    </c:if>
	 	</ul>
	</div>
</nav>