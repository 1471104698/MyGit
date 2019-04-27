<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.oy.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/default.css">
<script src='js/prefixfree.min.js'></script>
<link rel="stylesheet" type="text/css" href="css/styles.css">
	
<title>欢迎NovelIdea来到登录平台</title>

</head>
<style>
    #page{
        width:120px;                        /* 在外面画一个区域   */
        height:700px;
    }
    li{
        list-style:none;
    }
    a{
        text-decoration:none;               /* 去除a标签自带下划线   */
        color:blue;
        border:1px solid #999;
        background-color: #F0F0F0;
        text-align:center;
        margin:2px 5px;
        float:left;                         /* 设置浮动 */
        width:80px;
        height:20px;
    }
</style>

<body>
   <h1 style="color: #ffffff">NovelIdea登录界面</h1>
		

		<div style="text-align:center;">
		<span style="font-size:px;color:red;font-weight:bold;">${str2 }<br/>
		<% ServletContext sc=request.getServletContext();
			sc.setAttribute("str2", null);%>
		</span>		
		</div>
		<div style="text-align:center;">
		<span style="font-size:20px;color:red;font-weight:bold;">${str }<br/></span>		
		</div>
		
		
		<section class="stark-login">		
		<form action ="<%=request.getContextPath() %>/userServlet"  method ="post"> 		
		<input type="hidden" name="oper" value="login">
		
		<!-- hidden标签的表示此元素在页面中不显示，在提交表单时发送 value 属性的值。 -->
		学号：&emsp;<input type="text" placeholder="学号"  name="uid" required onkeyup="this.value=this.value.replace(/[^\d]/g,'');" >
		密码：&emsp;<input type="password" placeholder="密码"  name="upwd" required onkeyup="this.value=this.value.replace(/[^\d]/g,'');" >
		
		
		<button>LOGIN</button> 
		<ul>
		<li><a href="user/reg.jsp" >注册</a>&emsp;&emsp;
		<a href="user/find.jsp">找回密码</a>	</li>
		</ul>
		
		</form>
	<div class="hexagons">
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <span>&#x2B22;</span>
        <br>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <span>&#x2B22;</span>
          <br>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span> 
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            <span>&#x2B22;</span>
            
            <br>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>
              <span>&#x2B22;</span>

              </div>      
        </section>     
        <div id="circle1">
          <div id="inner-cirlce1">
            <h2> </h2>
          </div>
        
		</div>
		
</body>
</html>