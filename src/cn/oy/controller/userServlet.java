package cn.oy.controller;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.oy.service.implS;
import cn.oy.service.UserService;



@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	

	//获取service对象
	UserService us=new implS(); 

	
	private static final long serialVersionUID = 1L;
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//设置请求编码格式		
		req.setCharacterEncoding("utf-8");
//		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		
		String oper=req.getParameter("oper"); //判断操作符
		if("login".equals(oper)) {			//OK
			//调用登录方法
				try {
					checkUserLogin(req,resp);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}				//req封存了此次请求的所有数据，resp封存应怎么进行响应 的方式
		}else if("updatepwd".equals(oper)){			//OK
			//调用修改密码方法
			try {
				checkPwd(req,resp);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}else  if("reg".equals(oper)) {
			//调用注册方法
			try {
				checkReg(req,resp);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}else if("updateinfo".equals(oper)) {
			//调用修改个人信息方法
			checkUpinfo(req,resp);
		}else if("del".equals(oper)) {
			//调用删除用户方法
			checkDelete(req,resp);
		}else if("add".equals(oper)) {
			//调用增加用户方法
			try {
				checkAdd(req,resp);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}else if("modify".equals(oper)) {
			//调用管理员修改用户信息方法
			modifyUser(req,resp);
		}else if("out".equals(oper)) {
			//调用退出账户方法及销毁session
			userOut(req,resp);
		}else if("find".equals(oper)) {
			//调用找回密码方法
			checkFind(req,resp);
		}else if("pa".equals(oper)) {
			//调用分页方法
			checkPage(req,resp);
		}
	}
	
	//用户分页信息*********************************
	private void checkPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("pageServlet").forward(req, resp);
	}

	
	//找回密码*********************************
	private void checkFind(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("调用找回密码的servlet");
		req.getRequestDispatcher("findPwdServlet").forward(req, resp);
	}

	//用户注销*********************************
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		req.getRequestDispatcher("userOutServlet").forward(req, resp);
	}


	//管理员修改用户信息*********************************
	private void modifyUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("modifyUserServlet").forward(req, resp);
		
	}
	
	
	//增加用户*********************************
	private void checkAdd(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, NoSuchAlgorithmException {
		req.getRequestDispatcher("addUserServlet").forward(req, resp);
		
	}

	
	//删除用户*********************************
	private void checkDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("deleteServlet").forward(req, resp);
	}

	//修改个人信息*********************************
	private void checkUpinfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("upadteInforServlet").forward(req, resp);
	}

	//注册功能*********************************
	private void checkReg(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, NoSuchAlgorithmException {
		req.getRequestDispatcher("regServlet").forward(req, resp);
		
	}	
	
	//修改密码*********************************
	private void checkPwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NoSuchAlgorithmException {
		req.getRequestDispatcher("updatePwdServlet").forward(req, resp);
	}	
	
	
	//处理登录*********************************
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NoSuchAlgorithmException {
		req.getRequestDispatcher("loginServlet").forward(req, resp);
	}
}
