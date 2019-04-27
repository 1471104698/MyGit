package cn.oy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.oy.pojo.Page;
import cn.oy.pojo.User;
import cn.oy.service.implS;
import cn.oy.service.UserService;

/**
 * Servlet implementation class pageServlet
 */
@WebServlet("/pageServlet")
public class pageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Override
protected  void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
	   UserService us=new implS();
		//用户分页信息*********************************
	   String pf=req.getParameter("pf");					//得到全部用户信息的判定符
		 String uname=(String) req.getParameter("name");
		 String uid=(String) req.getParameter("uid");
		 System.out.println("得到的名字和id为："+uname+"  "+uid);
		 String dire=(String) req.getParameter("dire");		//在这卡了半天，，，用成了getAttribute()；。。。
		 System.out.println("servlet这里的dire:   "+dire+" 为空？");
		 HttpSession hs=req.getSession();
		 
		 if(pf==null) {
		 if(uname!=null) {		//保存分页的状态
			 hs.setAttribute("name", uname);
			 hs.setAttribute("id", null);
			 
		 }else if(uid!=null){
			 hs.setAttribute("id", uid);
			 hs.setAttribute("name", null);
		 }else if(uname==null&&uid==null&&dire!=null) {
			 hs.setAttribute("id", null);
			 hs.setAttribute("name", null);
			 hs.setAttribute("status", dire);
		 }
		 }else {
			 hs.setAttribute("id", null);
			 hs.setAttribute("name", null);
			 hs.setAttribute("status", null);
		 }
		
		 dire=(String) hs.getAttribute("status");
		
		 uname=(String) hs.getAttribute("name");
		
		 uid=(String) hs.getAttribute("id");
		 
		 System.out.println("2得到的名字和id为："+uname+"  "+uid);
		 List<User> users=null;
		 Page page=new Page();
		 
		 String cpage=req.getParameter("currentPage");
		 if(cpage==null) {
			 cpage="0";		//在最开始设置当前页面为第一页即0页
		 }
		 int currentPage=Integer.parseInt(cpage);		//得到当前页面
		 System.out.println("currentPage："+currentPage);
		 page.setCurrentPage(currentPage);
//			ps:注意顺序，如果先set的是页面大小，而总数据没得到，则   总数据/页面大小   会造成空指针
		 int totalCount=us.getTotaService(dire,uname,uid);		//得到用户总数
		 System.out.println("totalCount："+totalCount);
		 page.setTotalCount(totalCount);
		 
		 int pageSize=5;	 //建立页面大小
		 System.out.println("pageSize："+pageSize);
		 page.setPageSize(pageSize);
		 

		 System.out.println("尾页大小："+page.getTotalPage());  	
		 
		  users= us.queryUserService(currentPage, pageSize,dire,uname,uid);

		 
		 page.setUsers(users);	 
		 req.setAttribute("page", page); //已经将信息都分装到page中了，直接在页面得到page即可
		 req.getRequestDispatcher("user/pa.jsp").forward(req, resp);
			
		}
}


