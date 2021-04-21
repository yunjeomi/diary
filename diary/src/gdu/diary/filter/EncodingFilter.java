package gdu.diary.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {
	
	//생성자
    public EncodingFilter() {
    }

    //필터 시작 시
    public void init(FilterConfig fConfig) throws ServletException {
    }
    
    //필터 메소드
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	//타겟 요청이 실행 전 필터링
    	request.setCharacterEncoding("utf-8");
    	System.out.println("*Encoding filter*");
    	chain.doFilter(request, response);
    	//타겟 요청이 실행 후 필터링
    }
    
    //필터 종료 시
	public void destroy() {
	}



}
