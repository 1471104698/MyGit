<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="cn.oy.pojo.*"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='js/prefixfree.min.js'></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css">
</head>
<body style="background: url(${pageContext.request.contextPath }/images/bg.png) ;background-size:100%">
   <h1>个人信息界面</h1>	
   			<hr/>
   		<c:if test="${empty user }">
		<%
		ServletContext sc=request.getServletContext();
		String str2="因您许久未进行操作，请重新登录！！！";
		sc.setAttribute("str2", str2);
		response.sendRedirect("/NovelIdea/login.jsp");
		%>
		</c:if>
		
		<c:if test="${not empty user}">
   		<% String uid=((User)session.getAttribute("user")).getUname();
		if("admin".equals(uid)){
		%>
		&emsp;&emsp;<a href="${pageContext.request.contextPath }/user/admin.jsp">返回首页</a><br/><br/>
		<%} else{%>
		&emsp;&emsp;<a href="${pageContext.request.contextPath }/user/user.jsp">返回首页</a><br/><br/>
		<%} %>
		</c:if>
		
		<div style="text-align:center;">
		<span style="font-size:20px;color:black;font-weight:bold;">${str }<br/>
		</span>
		
		</div>
	<div >
	<table border="1">
		<thead>
		<tr>		<!-- tr是行 td是列 -->
		<th><input name="" type="checkbox" value="" checked="checked"/></th>	<!-- checked 打勾 -->
		<th>学号</th>
		<th>姓名</th>	
		<th>密码</th>
		<th>性别</th>
		<th>年龄</th>
		<th>手机号码</th>		
		<th>专业班级</th>
		<th>选择方向</th>
		<th>自我介绍</th>
		</tr>
		</thead>
		<tbody>
		<tr>
		
		<td><input name="" type="checkbox" value="" /></td>
		<td>${user.id}</td>
		<td>${user.uname}</td>
		<td>${user.upwd}</td>
		<td>${user.sex}</td>
		<td>${user.age}</td>
		<td>${user.tel}</td>			
		<td>${user.grade}</td>
		<td>${user.dire}</td>
		<td>${user.intro}</td>
		</tr>	
		</tbody>
		</table>
	</div>	
		<ul>
		<li><cite></cite><a href="${pageContext.request.contextPath }/user/updateInfo.jsp">修改个人信息</a></li>
		</ul>
</body>
</html>