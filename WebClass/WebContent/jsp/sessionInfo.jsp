<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.dimigo.vo.UserVO" %>
<!DOCTYPE html>
<%
	UserVO U = (UserVO)session.getAttribute("U");
%>
<h1>id: <%= U.getId() %></h1>
<h1>name: <%= U.getName() %></h1>
<h1>NickName: <%= U.getNickname() %></h1>