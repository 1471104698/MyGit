<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.oy.pojo.*" import="cn.oy.service.*" import="cn.oy.service.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改用户信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='js/prefixfree.min.js'></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css">
</head>
<body style="background: url(${pageContext.request.contextPath }/images/bg.png) ;background-size:100%">
   <h1 >管理员修改用户信息界面</h1>	
   			<hr/>
   		<c:if test="${empty user }">
		<%
			ServletContext sc=request.getServletContext();
				String str2="因您许久未进行操作，请重新登录！！！";
				sc.setAttribute("str2", str2);
				response.sendRedirect("/NovelIdea/login.jsp");
		%>
		</c:if>
   		<%
   			String id=(String)request.getParameter("uid"); 
   		   		   		   		UserService us=new implS(); 
   		   		   		   		User user=us.cheUserService(id);
   		%>
		&emsp;&emsp;<a href="${pageContext.request.contextPath }/user/admin.jsp">返回首页</a><br/><br/>
		<form action="${pageContext.request.contextPath }/userServlet" method="post">
			<input type="hidden" name="oper" value="modify">
			<input type="hidden" name="id" value=<%=id %>>
				
			<ul>
				<li>姓名：&emsp;&emsp;<input type="text" name="name" placeholder="姓名" value=<%=user.getUname() %>	maxlength="10" required onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');"></li>
				<li>年龄：&emsp;&emsp;<input type="text" name="age" placeholder="年龄"  value=<%=user.getAge() %> maxlength="3" required onkeyup="this.value=this.value.replace(/[^\d]/g,'');"></li>
				<li>手机号码：<input type="text" placeholder="手机号码" name="tel"  value=<%=user.getTel() %> maxlength="11" required onkeyup="this.value=this.value.replace(/[^\d]/g,'');"></li>
				<li>性别：&emsp;&emsp;<input type="radio" name="sex"  value="男" checked="checked">男
					  				  <input type="radio" name="sex" value="女" >女</li>
				<li>专业班级：<input type="text" name="grade"placeholder="专业班级" value=<%=user.getGrade() %> maxlength="15" required onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');"></li>
				<li>选择方向：<input type="radio"  name="dire" value="前端" checked="checked" >前端
							 <input type="radio"  name="dire" value="后台" >	后台</li>		
				<li>自我介绍：<br/><textarea cols="50" rows="10" name="intro"  ></textarea></li>
				<li>&emsp;&emsp;&emsp;<input type=submit value="确认修改"></li>
			</ul>	
			
		</form>
</body>
</html>