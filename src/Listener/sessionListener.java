package Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



public class sessionListener implements HttpSessionListener,ServletContextListener{
	public sessionListener() {
	}
	
//	SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");	//创建通知的时间格式
	static int i;
	@Override
	public void sessionCreated(HttpSessionEvent se) {		//建立session创建的监听
		System.out.println("session创建了");
//	System.out.println("有人登录了  ："+ sdf.format(new Date())+"\t"+"现在网页在线人数为："+i);	
	}
	
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {		//监听session的销毁，手动销毁或自动销毁，这里只是监听
		System.out.println("session销毁了");
	}	
	
	//application对象初始化
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	
		System.out.println("application对象被销毁了");		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc=sce.getServletContext();	
		sc.setAttribute("count",0);
		System.out.println("application对象被初始化了");		//application随服务器（tomcat）启动而启动
		ServletContextListener.super.contextInitialized(sce);
	}
	

}
