<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.dimigo.vo.UserVO"%>
<!DOCTYPE html>
<script src="/WebClass/js/login.js"></script>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/WebClass/blog/home.jsp">Home</a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <% UserVO U = (UserVO)session.getAttribute("U");
  	  if(U == null) { %>
  	  <li class="nav-item">
        <a class="nav-link" onClick="plzLogin()" href="">정보</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" onClick="plzLogin()" href="">활동</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" onClick="plzLogin()" href="">일정표</a>
      </li>	
  	  <%
  	    } else { %>
      <li class="nav-item">
        <a class="nav-link" href="/WebClass/blog/inform.jsp">정보</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/WebClass/blog/activate.jsp">활동</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/WebClass/blog/time.jsp">일정표</a>
      </li>
      <% } %>
    </ul>
    <%-- 세션에 사용자 정보가 없는 경우 --%>
    <%
    	if(U == null) {
    %>
    	<a class="text-bold text-white" style="text-decoration: none" href="/WebClass/blog/login.jsp">Sign in/Sign Up</a>
    <%
    	}
    	else {
    %>
    <%-- 세션에 사용자 정보가 있는 경우 --%>
	    <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
	    <li class="nav-item dropdown">
	      <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	    	<%= U.getName() %>님
	      </a>
	      <div class="dropdown-menu dropdown-menu-right" aria-labelledby="bd-versions">
	      	<form action="/WebClass/bloglogout" method="post">
		      	<button type="submit" class="dropdown-item">Sign out</button>
	      	</form>
	      </div>
	    </li>
	    </ul>
    <%
    	}
    %>
  </div>
</nav>