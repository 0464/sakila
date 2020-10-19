package sakila.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") // 전체 문서에 적용하는 필터
public class EncodingFilter implements Filter {

    public EncodingFilter() {

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 전체 문서 필터 디버깅
		System.out.println("EncodingFilter 실행 : request utf-8 인코딩");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
