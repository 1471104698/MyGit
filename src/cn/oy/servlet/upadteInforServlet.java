package cn.oy.servlet;

import java.io.IOException;
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
 * Servlet implementation class upadteInforServlet
 */
@WebServlet("/upadteInforServlet")
public class upadteInforServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  UserService us=new implS(); 
	  String uname=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String sex=req.getParameter("sex");
		String grade=req.getParameter("grade");
		String intro=req.getParameter("intro");
		String dire=req.getParameter("dire");
		String tel=req.getParameter("tel");
		User user=(User) req.getSession().getAttribute("user");
		if(user!=null) {
		user.setUname(uname); 
		user.setAge(age);
		user.setGrade(grade);
		user.setIntro(intro);
		user.setSex(sex);
		user.setDire(dire);
		user.setTel(tel);
		int result=us.upinfoService(user);
		System.out.println("修改个人信息result="+result);
		if(result==-1) {
			System.out.println("信息修改失败");
		}else {
			System.out.println("信息修改成功");	
			String str="个人信息修改成功";
			req.setAttribute("str", str);
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
			if("admin".equals(uname)) {
			req.getRequestDispatcher("user/information.jsp").forward(req, resp);
			}
			else {
			req.getRequestDispatcher("user/information.jsp").forward(req, resp);
			}			
		}
		}else {
			String str2="因您许久未进行操作，请重新登录！！！";
			req.setAttribute("str2", str2);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}	
}

}
