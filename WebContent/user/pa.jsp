<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"	import="java.util.*,cn.oy.servlet.*,cn.oy.pojo.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户分页信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='js/prefixfree.min.js'></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css">

</head>
<body style="background: url(${pageContext.request.contextPath }/images/bg.png) ;background-size:100%">

   <h1>用户分页信息</h1>	
   	<hr/>	
		<c:if test="${empty user }">
		<%
		ServletContext sc=request.getServletContext();
		String str2="因您许久未进行操作，请重新登录！！！";
		sc.setAttribute("str2", str2);
		response.sendRedirect("/CatDemo/login.jsp");   %>
		</c:if>
		
	
		
		<div style="text-align:center;">
		<span style="font-size:30px;color:black;font-weight:bold;">${str }<br/>
		</span>	
		</div>
		
		&emsp;&emsp;<a href="${pageContext.request.contextPath }/user/admin.jsp">返回首页</a><br/><br/>
		
	
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
		<c:forEach items="${page.users}" var="u">
		<tr>
		<td><input name="" type="checkbox"  /></td>
		<td>${u.id}</td>
		<td>${u.uname}</td>
		<td>${u.upwd}</td>
		<td>${u.sex}</td>
		<td>${u.age}</td>
		<td>${u.tel}</td>
		<td>${u.grade}</td>
		<td>${u.dire}</td>
		<td>${u.intro}</td>
		<td><a href="${pageContext.request.contextPath }/user/modify.jsp?uid=${u.id}">修改</a></td>&emsp;
		<td><a href="${pageContext.request.contextPath }/userServlet?oper=del&id=${u.id}">删除</a></td>		
		</tr>
		</c:forEach>
		</tbody>
		</table>
		<a href="${pageContext.request.contextPath }/userServlet?oper=pa&currentPage=0">首页</a>&emsp;&emsp;
		<c:if test="${page.currentPage>0}">																		
		<a href="${pageContext.request.contextPath }/userServlet?oper=pa&currentPage=${page.currentPage-1}">上一页</a>&emsp;&emsp;		
		
		</c:if>
		<c:if test="${page.currentPage eq 0}">
		<a href="#">上一页</a>&emsp;&emsp;
		</c:if>
		<c:if test="${page.currentPage<page.totalPage}">
		<a href="${pageContext.request.contextPath }/userServlet?oper=pa&currentPage=${page.currentPage+1}">下一页</a>&emsp;&emsp;
		</c:if>
		<c:if test="${page.currentPage==page.totalPage}">
		<a href="#">下一页</a>&emsp;&emsp;
		</c:if>
		<a href="${pageContext.request.contextPath }/userServlet?oper=pa&currentPage=${page.totalPage}">尾页</a><br/>
		
		<c:if test="${empty name and empty id }">
		<h2 class="ge">分类方式：</h2>
		<a href="${pageContext.request.contextPath }/userServlet?oper=pa&dire=前端">前端</a>&emsp;&emsp;
		<a href="${pageContext.request.contextPath }/userServlet?oper=pa&dire=后台">后台</a>&emsp;&emsp;
		<a href="${pageContext.request.contextPath }/userServlet?pf=1&oper=pa">全部</a>
		</c:if>
	</div>
</body>
</html>