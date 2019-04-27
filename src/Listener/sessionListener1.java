package Listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
//import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
//import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 创建一个实现了指定接口的java类
	 * 监听request-->ServletRequestListener 监听request对象的创建和销毁
	 * 				requestInitialized(ServletRequestEvent sre)//创建
	 * 				requestDestroyed(ServletRequestEvent sre)//销毁
	 * 
	 *  监听request-->ServletRequestAttributeListener  监听request作用域的变更
	 *  			attributeAdded(ServletRequestAttributeEvent srae)
	 *  			attributeRemoved(ServletRequestAttributeEvent srae)
	 *  			attributeReplaced(ServletRequestAttributeEvent srae)
	 *  	注意：形参可以获取监听数据
	 *  		srae.getName()		获取监听数据的键   request.setattribute(name,value)；
	 *  		srae.getValue()		获取监听数据的值
	 *  
	 *  监听session-->HttpSessionListener 监听session的创建和销毁，即监听的是用户会话对象的创建和销毁事件
	 *  			sessionCreated(HttpSessionEvent se)	创建session	
	 *  			sessionDestroyed(HttpSessionEvent se)	
	 *  		注意：形参可以获取被监听的session对象
	 *  		se.getSession();	//得到被监听的session对象 
	 *  
	 *  监听session-->HttpSessionAttributeListener 监听session数据的变更
	 *  			attributeAdded(HttpSessionBindingEvent event) 	
	 *  			event.getName();	
	 *  			event.getValue();		得到键值   	hs.setattribute(name,value);
	 *  监听application-->ServletContextListener 
	 *  			contextInitialized(ServletContextEvent sce)  初始化		//服务器启动
	 *  			contextDestroyed(ServletContextEvent sce)	销毁		//服务器关闭
	 *  	
	 *  		注意：形参可以获取当前application对象
	 *  			sce.getServletContext();
	 *  监听application-->ServletContextAttributeListener 
	 *  
	 *  		System.out.println("application中增加了一条数据-"+srae.getName()+":"+srae.getValue());
	 *  案例：统计当前在线人数
	 *  
	 *  在web中配置
	 *  <listener>
  		<listener-class>Listener.sessionListener</listener-class>
 		</listener>
 * @author hehe
 *
 */

public class sessionListener1 implements HttpSessionListener,ServletRequestListener,ServletRequestAttributeListener,HttpSessionAttributeListener,ServletContextListener,ServletContextAttributeListener{ 
	//需要在web中进行配置才能自动启动该功能
//		@Override			//request对象的创建
//		public void requestInitialized(ServletRequestEvent sre) {
//			System.out.println("我被创建了");
//			ServletRequestListener.super.requestInitialized(sre);
//		}
//		@Override		//request对象的销毁
//		public void requestDestroyed(ServletRequestEvent sre) {
//			System.out.println("我被销毁了");
//			ServletRequestListener.super.requestDestroyed(sre);
//		}
//		@Override
//		public void attributeAdded(ServletRequestAttributeEvent srae) {
//			
//			ServletRequestAttributeListener.super.attributeAdded(srae);
//			/**
//			 * 在servlet中用request.setattribute(name,value)；可以在这里得到属性名和属性值
//			 * request.setattribute(name,value)；
//			 * request.setattribute(name,value)；
//			 * request.setattribute(name,value)；而同时多个相同的属性名，则相当于覆盖，即下面的replace
//			 */
//		}
//		@Override
//		public void attributeRemoved(ServletRequestAttributeEvent srae) {
//			//移除
//			ServletRequestAttributeListener.super.attributeRemoved(srae);
//		}
//		@Override
//		public void attributeReplaced(ServletRequestAttributeEvent srae) {
//			//替换
//			ServletRequestAttributeListener.super.attributeReplaced(srae);
//		}
//	
//		
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");	//创建通知的时间格式
		static int i;
		@Override
		public void sessionCreated(HttpSessionEvent se) {		//建立session监听
			se.getSession();		//得到被监听的对象的数据
		System.out.println("有人登录了  ："+ sdf.format(new Date())+"\t"+"现在网页在线人数为："+i);	
		}
		
		
		@Override
		public void sessionDestroyed(HttpSessionEvent se) {		//销毁session
			i--;
		System.out.println("有人退出了"+sdf.format(new Date())+"\t"+"现在网页人数为："+i);
		}	
		
//		//监听session数据的变更
//		@Override
//		public void attributeAdded(HttpSessionBindingEvent event) {
//			System.out.println("session中增加了一条数据"+event.getName()+":"+event.getValue());		//hs.setattribute(name,value);
//			HttpSessionAttributeListener.super.attributeAdded(event);
//		}
//		@Override
//		public void attributeRemoved(HttpSessionBindingEvent event) {
//			
//			HttpSessionAttributeListener.super.attributeRemoved(event);
//		}
//		@Override
//		public void attributeReplaced(HttpSessionBindingEvent event) {
//			
//			HttpSessionAttributeListener.super.attributeReplaced(event);
//		}
//		
////----------------------------------------------------------------------------	
		//监听application对象初始化销毁
		@Override
		public void contextDestroyed(ServletContextEvent sce) {
		}

		@Override
		public void contextInitialized(ServletContextEvent sce) {
			ServletContext sc=sce.getServletContext();	
			sc.setAttribute("count",0);
			System.out.println("application对象被初始化了");		//application随服务器（tomcat）启动而启动
			ServletContextListener.super.contextInitialized(sce);
		}
//		//监听application对象数据变更
//		@Override
//		public void attributeAdded(ServletRequestAttributeEvent srae) {
//			System.out.println("application中增加了一条数据-"+srae.getName()+":"+srae.getValue());
//			ServletRequestAttributeListener.super.attributeAdded(srae);
//		}
//
//		@Override
//		public void attributeRemoved(ServletRequestAttributeEvent srae) {
//
//			ServletRequestAttributeListener.super.attributeRemoved(srae);
//		}
//
//		@Override
//		public void attributeReplaced(ServletRequestAttributeEvent srae) {
//
//			ServletRequestAttributeListener.super.attributeReplaced(srae);
//		}
		
}
