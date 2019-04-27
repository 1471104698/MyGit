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
 * Servlet implementation class addUserServlet
 */
@WebServlet("/addUserServlet")
public class addUserServlet extends HttpServlet {
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
			System.out.println("得到的信息为:   "+uname+ pwd+ sex+ age+ grade+ intro+dire);
			User user=new User(uid, uname, pwd, sex, age, grade, intro,tel,dire);			
			int result=us.addUserService(user);
			if(result>0) {
				System.out.println("添加成功");	
				String str="用户添加成功，可以进行查询查看用户信息";
				req.setAttribute("str", str);		
			req.getRequestDispatcher("user/admin.jsp").forward(req, resp);
					return ;
					
			}else {
				System.out.println("添加失败");
				String str="用户添加失败，该用户已存在";
				req.setAttribute("str", str);
				req.getRequestDispatcher("user/addUser.jsp").forward(req, resp);		
			}		
		}
			

}
