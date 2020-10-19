package sakila.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/auth/*")
public class LoginFilter implements Filter {


    public LoginFilter() {

    }

	public void destroy() {

	}
	
	// ServletRequest는 HttpServletRequest의 부모
	// ServletResponse는 HttpServletResponse의 부모
	// Filter는 웹브라우저 뿐만 아니라 네트워크 프로토콜과 같은 모든 요청을 필터링 한다.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 로그인이 되어 있다면(/auth/) 디버깅
		System.out.println("LoginFilter 실행 : session 검사");
		HttpSession session = ((HttpServletRequest)request).getSession();
		if(session.getAttribute("loginStaff") == null) {
			((HttpServletResponse)response).sendRedirect(request.getServletContext().getContextPath()+"/LoginServlet");
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
