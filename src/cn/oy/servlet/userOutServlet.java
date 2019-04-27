package cn.oy.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import cn.oy.user.User;

/**
 * Servlet implementation class userOutServlet
 */
@WebServlet("/userOutServlet")
public class userOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   //得到用户session
	 		HttpSession session=req.getSession();
	 		session.setAttribute("status", null);
	 		ServletContext sc=this.getServletContext();
	 		int count=(int)sc.getAttribute("count");
	 		sc.setAttribute("count", --count);
	 		sc.setAttribute("jid", null);
	 		session.setMaxInactiveInterval(0);
	 		//强制注销session
	 		session.invalidate();
	 		//登录界面
	 		resp.sendRedirect("login.jsp");	
}

}
