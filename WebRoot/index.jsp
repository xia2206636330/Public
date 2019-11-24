<%@page import="Biz.impl.NewsBizimpl"%>
<%@page import="Biz.NewsBiz"%>
<%@page import="nutil.passageQuery"%>
<%@page import="Dao.entity.User"%>
<%@page import="Dao.entity.News"%>
<%@page import="Dao.impl.NewsDaoImpl"%>
<%@page import="Dao.NewsDao"%>
<%@page import="Dao.entity.Type"%>
<%@page import="Dao.impl.TypeDaoimpl"%>
<%@page import="Dao.TypeDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  
  <body>
    <div>
    
    		<!-- 采用JSTL标签库获取登录人信息  -->   
    	<c:if test="${empty login}">
    	<a href = "Login.jsp">登录</a>   	
    	</c:if>
    	<c:if test="${not empty login}">
    	<a href = "Login.jsp">登录</a> 
    	登录人:${login.zhanghao};
    		<a href = "Logout_controller.jsp">注销</a>  	
    	</c:if>    	
    	
    		
    </div>
    <div>
    	<p>
    	<%
    		
    		%>
  			<c:forEach items="${types}" var="type">  			
  			<a href = "index.jsp?tid=${type.typeid}">${type.typename}></a>  			
  			</c:forEach>	
    	</p>       
    </div>
    
    
    <div>
    <table border = "3" width= "100%" style = "color:red">
	  <tr>
		  	<th>新闻编号</th>
		  	
		  	<th>新闻类型</th>
		  	
		  	<th>新闻标题</th>
		  	
		  	<th>新闻内容</th>
		  	
		  	<th>作者</th>
		  	
		  	<th>发布时间</th>
		  	
		  	<th>新闻图片</th>
	  		
	  </tr>
	 <%
	 passageQuery pq  = new passageQuery();
	 //获取当前页码
	 int currentpage = 0;
	 String curr = request.getParameter("currentpage");
	 if(curr == null){
		 currentpage = 1; 
	 }else{
		 currentpage = Integer.parseInt(curr);
	 }
	 pq.setCurrentpage(currentpage);
	 
	 
	 
	 
	 
	 //总记录数
	 NewsBiz nb = new NewsBizimpl();
	 String tid  = request.getParameter("tid");
	 Integer ntid = null;
	 if(tid!=null){
		 ntid=Integer.parseInt(tid);
	 }
	 //放到作用域
	 request.setAttribute("ntid", ntid);
	 int totalrows = nb.getCount(ntid);
	 pq.setTotalrows(totalrows);
	 
	 
	 
	 
	 
	 
	 //每页信息集合
	List<News> list =  nb.getByPage(pq.getCurrentpage(), pq.getPagesize(), ntid);
	 pq.setList(list);
	 //遍历新闻信息
	 List<News> news =pq.getList();
	 request.setAttribute("newspage", pq);
		%>
	 	<c:forEach items="${newspage.list}" var="news" varStatus="vs">
			 	 <tr>
				  	<td>${vs.count}</td>
				  	
				  	<td>${news.typeid}</td>
				  	<!-- 标题字数超过三位数后面隐藏 -->
				  	<td>${fn:substring(news.title,0,3)}……</td>
				  	 
				  	<td>${news.neirong}</td>
				  	
				  	<td>${news.writer}</td>
				  	
				  	
				  	<td>
				  	<!--格式化日期標簽-->
				  	<fmt:formatDate value="${news.newstime}" pattern="yyyy/MM/dd"/>
				  	</td>
				  	
				  	<td><img src="${news.nimg}" width = "60px" height = "50px"></td>	  		
			  </tr>
	</c:forEach>
	 	  
	  <tr>
		  <td colspan = "7">
		  
		  查詢縂數：${fn:length(newspage.list)}
		  
		  <!--用表達式改進  -->
		  <c:if test="${newspage.currentpage > 1}">
		  		<!-- 不等於空 -->
			  	<c:if test="${not empty ntid }">
				  	<a href="index.jsp?currentpage=1&tid=${ntid}">首页</a>
		   	   		<a href="index.jsp?currentpage=${newspage.currentpage-1 }&tid=${ntid}">上一页</a>			  	
			  	</c:if>
			  	
			  	<!--等于空  -->
			  	<c:if test="${ empty ntid }">
				  	<a href="index.jsp?currentpage=1">首页</a>
   	   				<a href="index.jsp?currentpage=${newspage.currentpage-1 }">上一页</a>			  	
			  	</c:if>
		   
		  
		  </c:if>
		  
		  
		  
		  
		  
		  <!--用表達式改進  -->
		  <c:if test="${newspage.currentpage < newspage.countpage }">
		  		<!-- 不等於空 -->
			  	<c:if test="${not empty ntid }">
				  	<a href="index.jsp?currentpage=${newspage.currentpage+1 }&tid=${ntid}">下一页</a>
   		   			<a href="index.jsp?currentpage=${newspage.countpage}>&tid=${ntid}">尾页</a>		  	
			  	</c:if>
			  	
			  	<!--等于空  -->
			  	<c:if test="${ empty ntid }">
				  	<a href="index.jsp?currentpage=${newspage.currentpage+1 }">下一页</a>
   		   			<a href="index.jsp?currentpage=${newspage.countpage}">尾页</a>	  	
			  	</c:if>
		   
		  
		  </c:if>
		  </td>
	  </tr>
	</table>         
    </div>
  </body>
</html>
