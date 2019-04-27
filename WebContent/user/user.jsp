<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.oy.pojo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NovelIdea官网</title>
<script src="jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='js/prefixfree.min.js'></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css">
<script type="text/javascript">
	$(function(){	//入口函数
		//退出功能
		$("#out").click(function(){
			var flag=window.confirm("你真的要退出么？？？");
			if(flag){
				window.location.href="${pageContext.request.contextPath }/userServlet?oper=out"; 
			}
		})
		
	})
</script>
</head>
<body style="background: url(${pageContext.request.contextPath }/images/bg.png) ;background-size:100%">
   <h1 >用户界面</h1>		
   	<hr/>
		<c:if test="${empty user }">
		<%
		ServletContext sc=request.getServletContext();
		String str2="因您许久未进行操作，请重新登录！！！";
		sc.setAttribute("str2", str2);
		response.sendRedirect("/NovelIdea/login.jsp");   %>
		</c:if>
		
		<div>
		<span>用户名：${sessionScope.user.uname}</span><br/>
		<span>当前在线人数：${applicationScope.count}</span>
		</div>
		<div style="text-align:center;">		<!-- 居中 -->
		<h1 style="color: #97FFFF">欢迎进入NovelIdea官网</h1>
		</div>
		<dl>
		<dd>			
		<h2>功能区</h2>			
		<h3>个人信息管理</h3>
			<ul>
							<!-- target重开一个网页  _blank-->
			<li><cite></cite><a href="${pageContext.request.contextPath }/user/information.jsp" target="_self">查看个人信息</a><i></i></li> 	
			<li><cite></cite><a href="${pageContext.request.contextPath }/user/updatePwd.jsp" target="_self">修改密码</a><i></i></li>
			</ul>	
			<br/>	
			<!-- ul li标签 是一对无序清单列表，如新闻列表 
			用ul li 是因为他是一个列表标签-->
			
		</dd>
		</dl>
		<dl>
		<dd>
		<ul>
		<li><a href="#" id="out">退出账户</a></li>
		</ul>
		</dd>
		</dl>
		
		
</body>
</html>