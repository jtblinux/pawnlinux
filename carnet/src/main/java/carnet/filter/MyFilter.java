package carnet.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MyFilter
 */
public class MyFilter implements Filter {
     List<String> paths;
 	
    /**
     * Default constructor. 
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse)response;
        System.out.println(paths);
        System.out.println("user:"+req.getSession().getAttribute("user"));
        String uri=req.getRequestURI();
        uri=uri.substring(uri.lastIndexOf("/"));
        if(!paths.contains(uri)) { 
        	   //不包含user.
        	if(req.getSession().getAttribute("user")==null) {
        		  resp.sendRedirect(req.getContextPath()+"/jsp/login.jsp");
        		  return;
        	}
        }
		// pass the request along the filter chain
        System.out.println("doit");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		  paths=new ArrayList<String>();
		  String [] urls =fConfig.getInitParameter("paths").split(",");
		  for(int i=0;i<urls.length;i++) {
			   paths.add(urls[i]);
		  }
	}

}
