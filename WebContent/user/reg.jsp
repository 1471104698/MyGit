<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='js/prefixfree.min.js'></script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css">
</head>
<body style="background: url(${pageContext.request.contextPath }/images/bg.png) ;background-size:100%">
		

   <h1>注册界面</h1>		<hr/>
		
		<div style="text-align:center;">
		<span style="font-size:20px;color:black;font-weight:bold;">${str }<br/>
		</span>
		
		</div>
		 &emsp;&emsp;<a href="${pageContext.request.contextPath }/login.jsp">返回登录界面</a><br/><br/>
		<form action="${pageContext.request.contextPath }/userServlet" method="post" >
		<input type="hidden" name="oper" value="reg">	
			<ul>
				<li>学号：&emsp;&emsp;<input type="text" placeholder="学号" name="uid"   required onkeyup="this.value=this.value.replace(/[^\d]/g,'');"></li>
				<li>姓名：&emsp;&emsp;<input type="text"placeholder="姓名" name="uname"   required onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');"></li>
				<li>密码：&emsp;&emsp;<input type="password" placeholder="密码" name="upwd" maxlength="40" required onkeyup="this.value=this.value.replace(/[^\w]/g,'');"></li>
				<li>手机号码：<input type="text" placeholder="手机号码" name="tel"  required onkeyup="this.value=this.value.replace(/[^\d]/g,'');"></li>
				<li>年龄：&emsp;&emsp;<input type="text" placeholder="年龄" name="age" required onkeyup="this.value=this.value.replace(/[^\d]/g,'');"></li>
				<li>性别：&emsp;&emsp;<input type="radio"  placeholder="性别" name="sex" value="男" checked="checked">男
					  <input type="radio" name="sex" value="女" >女</li>
				<li>专业班级：<input type="text" placeholder="专业班级" name="grade" required onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');"></li>
				<li>选择方向：<input type="radio"  name="dire" value="前端" checked="checked" >前端
							 <input type="radio"  name="dire" value="后台" >后台	</li>			 
				<li>自我介绍：<br/><textarea cols="50" rows="10" name="intro" ></textarea></li>
				<li>&emsp;&emsp;&emsp;<input type=submit value="注册">
			<input type="reset"><br></li>
			</ul>	
			
		</form>
		
</body>
</html>