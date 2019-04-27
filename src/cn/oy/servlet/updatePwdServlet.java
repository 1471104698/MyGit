package cn.oy.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.oy.pojo.User;
import cn.oy.service.implS;
import cn.oy.service.UserService;

/**
 * Servlet implementation class updatePwdServlet
 */
@WebServlet("/updatePwdServlet")
public class updatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   UserService us=new implS(); 
	   
	   //获取数据
	 		//从session中获取用户信息
	 		String npwd=req.getParameter("newPwd");
	 		String cpwd=req.getParameter("cfPwd");
	 		User user=(User) req.getSession().getAttribute("user");
	 		if(user!=null) {
	 		String uid=user.getId();
	 		int result=0;
	 		System.out.println("得到的user为："+user);
//	 		System.out.println("修改后密码为："+newpwd);	
	 		//进行密码校验	

	 		if(npwd.equals(cpwd)) {
	 			System.out.println("调用了2");
	 			//调用service处理
	 			result=us.changePwdService(cpwd, uid);		
	 		if(result>0) {
	 			System.out.println("密码修改成功");
	 			ServletContext sc=this.getServletContext();
	 			sc.setAttribute("jid", null);
	 			int count=(int)sc.getAttribute("count");
	 			sc.setAttribute("count", --count);
	 			String str="密码修改成功请重新登录";
				req.setAttribute("str", str);				//建立密码修改成功显示标识符
	 			System.out.println("得到的user为："+user);
	 			req.getRequestDispatcher("login.jsp").forward(req, resp);
	 			return;
	 				
	 		}else {			
	 			System.out.println("修改失败");			
	 			return;
	 		}
	 		}else {
	 			req.setAttribute("flag", 1);
	 			String str="两次密码输入不一致，请重新输入";
				req.setAttribute("str", str);	  //添加密码不一致的标识符然后在界面显示
	 			req.getRequestDispatcher("user/updatePwd.jsp").forward(req, resp);
	 		}
	 			}else {
	 				String str2="因您许久未进行操作，请重新登录！！！";
	 				req.setAttribute("str2", str2);
	 				req.getRequestDispatcher("login.jsp").forward(req, resp);
	 			}
	 	
   }

}
