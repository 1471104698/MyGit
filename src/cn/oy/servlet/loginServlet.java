package cn.oy.servlet;

import java.io.IOException;
//import java.util.Date;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.oy.pojo.User;
import cn.oy.service.implS;
import cn.oy.service.UserService;

/**
 * Servlet implementation class loginServlet
 * @param <V>
 * @param <K>
 * @param <E>
 */
@WebServlet("/loginServlet")
public class loginServlet<V, K, E> extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   UserService us=new implS(); 
	   
		//获取请求信息
		String uid=req.getParameter("uid");
		String upwd=req.getParameter("upwd");
		System.out.println("得到的账号密码：="+uid+" "+upwd);
		Map<String,Object> map=(Map<String, Object>) new HashMap<String, Object>();
		
			//处理请求信息
					//进行确认
			ServletContext sc=this.getServletContext();			
			HttpSession session=req.getSession();
			System.out.println(session.getId());
			User u=us.checkLoginService(uid, upwd);
			System.out.println("得到的用户="+u);
			String str1=(String) session.getAttribute("ocode");		//此段进行验证码校对
			String str2=req.getParameter("vcode");
			str2=str2.toLowerCase();		//转小写，达到不区分大小写的作用
			if(str1.equals(str2)) {			
			if(u!=null) {	
				if(session.getAttribute("status")==null) {
					session.setAttribute("status", 1);
				map.put(uid, session.getId());
				sc.setAttribute("map", map);
				sc.setAttribute("uid", uid);
				
				int count=(int)sc.getAttribute("count");//建立全局变量count来计算在线人数
				sc.setAttribute("count", ++count);					
				
				session.setAttribute("user",u);	//将用户数据存储到session中,命名为user，以后取用参数为该名
				System.out.println("用户信息为="+u);
				String uname=u.getUname();
				//重定向，请求进行了两次，数据在第一次中
				if("admin".equals(uname)) {		//是管理员账户就跳转到管理员页面
					resp.sendRedirect("user/admin.jsp");
				}else {
				resp.sendRedirect("user/user.jsp");
				}
				}else {
					String str="用户已在别处登录";
					req.setAttribute("str", str);	
					req.getRequestDispatcher("login.jsp").forward(req, resp);	
					
				}
				
			}
			else {	//************************
				//添加标识符
				String str="用户名或密码错误，请重新检查登录";
				req.setAttribute("str", str);	
				//请求转发,得到的request的数据和对比错误的数据库的数据不一样，因此可以用标识符把那句用户和密码错误选择性地在网页显示
				req.getRequestDispatcher("login.jsp").forward(req, resp);	
				return ;
			}						
		}
			else {
				String str="验证码输入错误，请重新输入";
				req.setAttribute("str", str);	
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
   }
}
