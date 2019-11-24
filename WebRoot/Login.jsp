<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style >
	.jinggao{
			color:red;
	}
	</style>

  </head>
  
  <body>
   <h1>用户登录</h1>
   <%
   String status =(String) session.getAttribute("status");
   if(status!=null){
	   %>
	   <p class = "jinggao">用户名或密码错误</p>  
	   <% 
   			}
   		%>
   
   
   <form action="LoginServlet" method = "post">
	   <p>账号:<input type ="text" name = "account"/></p>
	   <p>密码:<input type ="password" name = "upwd"/></p>
	   <p><input type ="submit" value = "登录"/></p>
   </form>
  </body>
</html>
