package cn.oy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.oy.service.implS;
import cn.oy.service.UserService;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 UserService us=new implS(); 
	 String uid=req.getParameter("id");
		int result=us.deleteService(uid);
		if(result==-1) {
			resp.getWriter().write("删除失败");
			System.out.println("删除失败");
			req.getRequestDispatcher("user/pa.jsp").forward(req, resp);		
		}else {
			resp.getWriter().write("删除成功");
			System.out.println("删除成功");
			String str="删除成功";
			req.setAttribute("str", str);
			req.getRequestDispatcher("pageServlet").forward(req, resp);
				return ;		
		}
	}

}
