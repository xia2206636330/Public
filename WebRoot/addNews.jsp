<%@page import="Dao.entity.Type"%>
<%@page import="Dao.impl.TypeDaoimpl"%>
<%@page import="Dao.TypeDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    
    <title>添加新闻</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <body>
   <form action="uploadServlet" method = "post" enctype = "multipart/form-data">
   		<p>类型:<select name = "type">
   			<%
    	TypeDao td = new TypeDaoimpl();
    	List<Type> ts = td.findAll();
    	request.setAttribute("types", ts);
    		%>
  			   <c:forEach items="${types}" var="type">
  			   <option value="${type.typeid }">${type.typename}</option>
  			   </c:forEach>
   				</select>
  		 </p>
  		 <p>标题:<input type = "text" name = "title"/></p>
  		 <p>内容:<input type = "text" name = "neirong"/></p>
  		 <p>作者:<input type = "text" name = "writer"/></p>
  		 <p>图片:<input type = "file" name = "img"/></p>
  		 <p><input type = "submit" value = "提交 " 	/></p>
   </form>
  </body>
</html>
