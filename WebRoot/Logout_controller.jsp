<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
//用户注销登录信息

session.invalidate();
response.sendRedirect("Login.jsp");


%>
