package Filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.oy.pojo.User;

/**
 * Servlet Filter implementation class userFilter
 * @param <E>
 */
@WebFilter("/userFilter")
public class userFilter<E> implements Filter {

    /**
     * Default constructor. 
     */
    public userFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("过滤器销毁。。。");
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("user");
		String jid=null;
		String uid=null;
		if(user!=null) {
			jid=session.getId();
			uid=user.getId();
			System.out.println("前面的uid="+uid+",jid="+jid);
		ServletContext sc=req.getServletContext();
		Map<String,Object> map=(Map<String, Object>) sc.getAttribute("map");
		if(map!=null) {
			for(Map.Entry<String,Object> entry:map.entrySet()) {	//遍历用户
				String strk=entry.getKey();
				String strv=(String) entry.getValue();
				if(strk.equals(uid)) {		//判断uid看看是否是相同用户
					if(jid!=null) {
					if(jid.equals(strv)){		//jseesionid相同则不拦截（除了相同浏览器）
					}else {
						int count=(int)sc.getAttribute("count");//	将去除重复登录的数
						sc.setAttribute("count", --count);	
						session.invalidate();
						System.out.println("uid="+uid+",jid="+jid);
						String str="账户已在其他地方登录！！！";
						sc.setAttribute("str2", str);						
						response.sendRedirect(request.getContextPath()+"/login.jsp");		//跳转登录界面					
						System.out.println("hehe");	
						return;
					}
					}
				}		
			}
		}
		}
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("过滤器初始化。。。");
	}

}
