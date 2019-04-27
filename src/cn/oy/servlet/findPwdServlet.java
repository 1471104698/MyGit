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
 * Servlet implementation class findPwd
 */
@WebServlet("/findPwdServlet")
public class findPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	   UserService us=new implS(); 
    	   String uid=req.getParameter("uid");
   		String uname=req.getParameter("uname");
   		String tel=req.getParameter("tel");
   		User user=us.checkFindService(uid,uname,tel);
   		System.out.println("调用了找回密码方法");
   		if(user!=null) {
   			HttpSession session=req.getSession();
   			session.setAttribute("user",user);	
   			session.setAttribute("find1",1);		//设置标识符，进行判断是否是找回密码的页面转过来的，是的话则不显示首页
   			String str="信息匹配成功，请输入新密码";
			req.setAttribute("str", str);
   			req.getRequestDispatcher("user/updatePwd.jsp").forward(req, resp);
   		}else {
   			String str="信息输入不匹配，请重新校验输入";
			req.setAttribute("str", str);
   			req.getRequestDispatcher("user/find.jsp").forward(req, resp);
   		}		
    	}
  

}
