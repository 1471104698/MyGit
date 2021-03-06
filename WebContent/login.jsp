<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.oy.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='js/prefixfree.min.js'></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>欢迎NovelIdea来到登录平台</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css">
</head>

<body>

   <h1 >NovelIdea登录界面</h1>
		<hr />
		<div class="oo">
		${str2 }
		<% ServletContext sc=request.getServletContext();
			sc.setAttribute("str2", null);%>
		${str }</div>
		<br/>
		<div>
		<section class="stark-login">			
		<form action ="${pageContext.request.contextPath}/userServlet"  method ="post"> 		
		<input type="hidden" name="oper" value="login">
		<ul>
		<!-- hidden标签的表示此元素在页面中不显示，在提交表单时发送 value 属性的值。 -->
		<li>学号：&emsp;<input type="text" placeholder="学号"  name="uid" maxlength="10" required onkeyup="this.value=this.value.replace(/[^\d]/g,'');" ><br/></li>
		<li>密码：&emsp;<input type="password" placeholder="密码"  maxlength="40" name="upwd" required onkeyup="this.value=this.value.replace(/[^\w]/g,'');" ><br/></li>
		<li>验证码：<input type="text" name="vcode" required placeholder="验证码"  maxlength="4" onkeyup="this.value=this.value.replace(/[^\w]/g,'');">
      <br>
			  <img id="img1" src="${pageContext.request.contextPath}/getImage" style="cursor:pointer" width="120" height="30" onclick="refreshImage();"/></li>
		<li>看不清？点击图片更新验证码</li>
		<li><input type="submit" value="登录">&emsp;&emsp;	
		<input type="reset"><br>&emsp;&emsp;&emsp;</li>	
		<li><h2>其他功能：</h2></li>
		<li><a href="user/reg.jsp" >注册</a>&emsp;&emsp;
		<a href="user/find.jsp" >找回密码</a></li>	
		</ul>		
		</form>	

	 </section>   
     <script type="text/javascript">
		function refreshImage(){
			var d = new Date();
			var t = d.getTime();
			var img = document.getElementById("img1");
			img.src = "${pageContext.request.contextPath}/getImage?timestamp="+t;
		}
	</script>  
		</div>
		
</body>
</html>