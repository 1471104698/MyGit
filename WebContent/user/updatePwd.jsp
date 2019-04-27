<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="cn.oy.pojo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>密码修改</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='js/prefixfree.min.js'></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css">
</head>
<body style="background: url(${pageContext.request.contextPath }/images/bg.png) ;background-size:100%">
   <h1>更新密码界面</h1>	
   	<hr/>
 	    <c:if test="${empty user }">
		<%
		ServletContext sc=request.getServletContext();
		String str2="因您许久未进行操作，请重新登录！！！";
		sc.setAttribute("str2", str2);
		response.sendRedirect("/NovelIdea/login.jsp");   %>
		</c:if>
   
   		<c:if test="${not empty user}"> 
   		<%Object find1=session.getAttribute("find1");		//这里得到前面拿到的标识符，进行判断是否是找回密码的页面转过来的，是的话则不显示首页
   			if(find1==null){%>
   		<c:if test="${empty flag }">
   		<% String uid=((User)session.getAttribute("user")).getUname();
		if("admin".equals(uid)){
		%>
		&emsp;&emsp;<a href="${pageContext.request.contextPath }/user/admin.jsp">返回首页</a><br/><br/>
		<%} else{%>
		&emsp;&emsp;<a href="${pageContext.request.contextPath }/user/user.jsp">返回首页</a><br/><br/>
		<%} %>
		</c:if>
		<%}else{%>
		&emsp;&emsp;<a href="${pageContext.request.contextPath }/login.jsp">返回登录界面</a><br/><br/>
		<%}session.setAttribute("find1", null);	//对表示符进行置空，否则后面登录时会不现实首页 %>	
		</c:if>
		
		<div style="text-align:center;">
		<span style="font-size:20px;color:black;font-weight:bold;">${str }<br/>
		</span>
		</div>
		
		<div style="text-align:center;">
		<form  action ="${pageContext.request.contextPath }/userServlet"  method="post">	<!-- 将值传给user -->
			<input type="hidden" name="oper"  value="updatepwd">
			<ul>
		&emsp;&emsp;	<li>新密码：<input type="text" name="newPwd" placeholder="新密码"  id="newPwd" required onkeyup="this.value=this.value.replace(/[^\w]/g,'');">  <!-- 给一个元素名称便于在User中校验 ,--> 
			&emsp;&emsp;<span style="font-size:15px;color:black;font-weight:bold;">请输入新密码</span></li>
		&emsp;&emsp;	<li>确认密码：<input type="text" name="cfPwd" placeholder="确认密码"  id="cfPwd" required onkeyup="this.value=this.value.replace(/[^\w]/g,'');">  <!-- confirm -->
			&emsp;&emsp;<span style="font-size:15px;color:black;font-weight:bold;">再次输入新密码</span></li>
			</ul>		
			<!-- li是不能单独使用，必须在于ul之中，能使标签按行排好 -->
			<input type="submit"  class="btn" value="确认修改" onclick="register()">
			<span id="tip"></span>
		</form>
		</div>
</body>
</html>