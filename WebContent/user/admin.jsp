<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.oy.pojo.*" import="cn.oy.Servlet.*"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NovelIdea官网</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='js/prefixfree.min.js'></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css">
<script src="jquery-3.3.1.min.js"></script>
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
	
   <h1>管理员界面</h1>
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
		
		
		<h1 style="color: #97FFFF">欢迎进入NovelIdea官网</h1>
		
		
		<div style="text-align:center;">
		<span style="font-size:20px;color:black;font-weight:bold;">${str }<br/>
		</span>
		
		</div>
		
		<c:if test="${not empty requestScope.ad1 }">
		<div style="text-align:center;">
		<span style="font-size:20px;color:black;font-weight:bold;"><br/>添加用户成功,可以进行查询对信息进行校验</span>
		</div>
		</c:if>
		<dl>
		<dd>
		<h2>功能区</h2>			
		<h3>个人信息管理</h3>

			<ul>
							<!-- target重开一个网页 -->
			<li><cite></cite><a href="${pageContext.request.contextPath }/user/information.jsp" target="_self">查看个人信息</a><i></i></li> 	
			<li><cite></cite><a href="${pageContext.request.contextPath }/user/updatePwd.jsp" target="_self">修改密码</a><i></i></li>
			</ul>		
			<!-- ul li标签 是一对无序清单列表，如新闻列表 
			用ul li 是因为他是一个列表标签-->
			<br/>	
		</dd>
		
		<dd>
		<h3>管理信息</h3>
			<ul> 			<!-- href 超文本引用 -->
			<li><cite></cite><a href="${pageContext.request.contextPath }/user/addUser.jsp" target="_self">增加用户</a><i></i></li>
			<li><cite></cite><a href="${pageContext.request.contextPath }/userServlet?oper=pa&pf=1" target="_self">所有用户信息</a><i></i></li>
			<li><cite></cite><a href="${pageContext.request.contextPath }/user/inquire.jsp" target="_self">查询用户</a><i></i><br/>	</li>
			
			</ul>
		</dd>
		</dl>
		<dl>
		<dd>
		<ul>	
		<li><a href="javascript:java(0)" id="out">退出账户</a></li>
		</ul>
		</dd>
		</dl>
</body>
</html>