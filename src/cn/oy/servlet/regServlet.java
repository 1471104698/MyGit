package cn.oy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.oy.pojo.User;
import cn.oy.service.implS;
import cn.oy.service.UserService;

/**
 * Servlet implementation class regServlet
 */
@WebServlet("/regServlet")
public class regServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 UserService us=new implS(); 
		String uid=req.getParameter("uid");
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("upwd");
		String sex=req.getParameter("sex");
		int age=Integer.parseInt(req.getParameter("age"));
		String grade=req.getParameter("grade");
		String intro=req.getParameter("intro");
		String dire=req.getParameter("dire"); 
		String tel=req.getParameter("tel");
		System.out.println("得到的信息为:   "+uname+ pwd+ sex+ age+ grade+" "+ "自我介绍："+intro+"方向:："+dire);
		User user=new User(uid, uname, pwd, sex, age, grade, intro,tel,dire);			
		int result=us.regService(user);
		if(result>0) {
			System.out.println("注册成功");
			String str="注册成功，您可以进行登录";
			req.setAttribute("str", str);			//建立注册成功显示标识符
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else {
			System.out.println("注册失败");
			String str="注册失败，该用户已存在";
			req.setAttribute("str", str);			//建立注册失败显示标识符
			req.getRequestDispatcher("user/reg.jsp").forward(req, resp);
		}	
    }

}
