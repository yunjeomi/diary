package gdu.diary.filter;

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

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/auth/*")
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//로그인 되어 있지 않은 상태에서 "/Auth/"문자로 시작하는 요청이 들어오면 redirect -> 로그인페이지?

		//ServletRequest(Response)은 HttpServletRequest(Response)의 부모라서 강제 형변환을 해줘야 한다.
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		HttpSession session = httpRequest.getSession();
		if(session.getAttribute("sessionMember") == null) {	//scope생략으로 이름이 헷갈리지 않게 하기 위해 member가 아닌 sessionMember로 저장해준다.
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/login");
			return; //새로운 요청발생으로 doFilter메소드 종료
		}
		//return은 doFilter밑으로 다른 메소드가 있을 경우 실행이 안 되니 꼭 확인하고 사용 할 것
		chain.doFilter(request, response);
	}
	
	public AuthFilter() {
	}
	
	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
