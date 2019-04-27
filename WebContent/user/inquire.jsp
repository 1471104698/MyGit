<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询用户</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='js/prefixfree.min.js'></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css">
</head>
<body style="background: url(${pageContext.request.contextPath }/images/bg.png) ;background-size:100%">
   <h1>查询界面</h1>	
   	<hr/>
   <c:if test="${empty user }">
		<%
		ServletContext sc=request.getServletContext();
		String str2="因您许久未进行操作，请重新登录！！！";
		sc.setAttribute("str2", str2);
		response.sendRedirect("/NovelIdea/login.jsp");   %>
		</c:if>
	&emsp;&emsp;<a href="${pageContext.request.contextPath }/user/admin.jsp">返回首页</a><br/><br/>
		<span style="font-size:30px;color:black;font-weight:bold;"><br/>选择要进行查询的项，支持模糊查询</span><br/><br/><br/>
		
		<form action="${pageContext.request.contextPath }/userServlet" method="post">
			<input type="hidden" name="oper" value="pa">
			按姓名查询:<input type="text" placeholder="姓名"  required name="name" onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');">
			<input type="submit" value="点击查询">
		</form>
		
		<form action="${pageContext.request.contextPath }/userServlet" method="post">
			<input type="hidden" name="oper" value="pa">
			按学号查询:<input type="text" placeholder="学号" required name="uid" onkeyup="this.value=this.value.replace(/[^\w]/g,'');">
			<input type="submit" value="点击查询">
		</form>
		
</body>
</html>