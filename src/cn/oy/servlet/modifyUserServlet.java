
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
 * Servlet implementation class modifyUserServlet
 */
@WebServlet("/modifyUserServlet")
public class modifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   UserService us=new implS(); 
		   String uid=req.getParameter("id");
			System.out.println("uid="+uid);
			int age=Integer.parseInt(req.getParameter("age"));
			String sex=req.getParameter("sex");
			String grade=req.getParameter("grade");
			String intro=req.getParameter("intro");
			String dire=req.getParameter("dire");
			String uname=req.getParameter("name");
			String tel=req.getParameter("tel");
			User user=new User(uid, uname, null, sex, age, grade, dire, tel,intro);
			int result=us.modifyUserService(user);		
			if(result>0) {
				System.out.println("修改成功");
				String str="用户信息修改成功，请进行信息校验";
				req.setAttribute("str", str);
					req.getRequestDispatcher("pageServlet").forward(req, resp);
					return ;
					
			}else {
				System.out.println("修改失败");
			}				
	}

}
